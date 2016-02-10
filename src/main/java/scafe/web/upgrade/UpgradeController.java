package scafe.web.upgrade;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scafe.domain.AppManager;
import scafe.domain.User;
import scafe.domain.utils.SecurityUtil;
import scafe.service.AppManagerService;
import scafe.service.UserService;

@Controller
@RequestMapping("/upgrade")
public class UpgradeController {
	
	@Autowired
	AppManagerService appManagerService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String getAppManager(Model model, HttpServletRequest request){
		
		AppManager appManager = (AppManager)request.getSession().getAttribute("AppManager");
		if(appManager == null)
			appManager = new AppManager();
		model.addAttribute("appManager", appManager);		
		return "/board/upgrade";
	}
	@RequestMapping(value = {"","/list"}, method = RequestMethod.POST)
	public String postAppManager(AppManager appManager, BindingResult result,HttpServletRequest request, Model model){
		UserDetails scafeUserDetail = SecurityUtil.getCurrentUserDetails();
		User user = userService.getUserByEmail(scafeUserDetail.getUsername());			
		if(user.getRoles().get(0).getName().equals("USER")){
			appManager.setUserEmail(user.getEmail());
			appManager.setUserId(user.getId());
			appManager.setUserName(user.getName());
			appManager.setApplicateAt(new Date());
			appManagerService.addAppManager(appManager);
			return "redirect:/board";			
		}
		
		System.out.println("Already Manager or Admin");
		return "/board/upgrade";		
	}

}

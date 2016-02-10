package scafe.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import scafe.domain.AppManager;
import scafe.domain.Role;
import scafe.domain.User;
import scafe.service.AppManagerService;
import scafe.service.RoleService;
import scafe.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public AppManagerService appManagerService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public RoleService roleService;
	
	@RequestMapping(value="")
	public String indexAdmin (Model model){
		return "redirect:/admin/list";
	}
	
	@RequestMapping(value = "/list")
	public String applyManagerList(Model model, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable){
		Page <AppManager> appManagerPage = appManagerService.findAll(pageable);
		model.addAttribute ("appManagerPage", appManagerPage);
		return "/admin/list";
	}
	
	@RequestMapping(value = "/upgrade/{id}")
	public String upgradeUser (@PathVariable int id, Model model){
		AppManager appManager = appManagerService.findOne(id);
		User user = userService.getUserByEmail(appManager.getUserEmail());
		Role role = roleService.findByRoleName("MANAGER");
		userService.changeRole(user, role);
		appManagerService.deleteAppManager(appManager);
		return "redirect:/admin";
	}

}

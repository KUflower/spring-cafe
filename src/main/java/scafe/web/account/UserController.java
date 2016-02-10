package scafe.web.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scafe.domain.User;
import scafe.service.UserService;
import scafe.web.account.form.LoginForm;
import scafe.web.account.form.LoginFormValidator;
import scafe.web.account.form.UserForm;
import scafe.web.account.form.UserFormValidator;

@Controller
@RequestMapping( value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
		
	@Autowired
	private UserFormValidator validator;
	
	@Autowired
	private LoginFormValidator validator2;
	
	@InitBinder(value = "userForm")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@InitBinder(value = "loginForm")
	private void initBinder2(WebDataBinder binder){
		binder.setValidator(validator2);
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String getLogin (Model model, HttpServletRequest request){
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm", loginForm);
				 		 
		return "/account/login";
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String postLogin (@Valid LoginForm loginForm, BindingResult result, HttpServletRequest request, Model model ){		
		if(result.hasErrors()){
			return "/account/login";
		}				
		
		UserSession userSession = new UserSession();		
		int id = userService.getIdByUserEmail(loginForm.getEmail());		
		User loginUser = userService.getOne(id);
		userSession.setEmail(loginUser.getEmail());
		userSession.setId(loginUser.getId());
		userSession.setName(loginUser.getName());
		userSession.setRoles(loginUser.getRoles());
		request.setAttribute("userSession", userSession);
		request.getSession().removeAttribute("loginForm");
		request.getSession().removeAttribute("user");
		
		System.out.println(userSession.getEmail());
		return "redirect:/user/success";
	}
	
	@RequestMapping(value="/success")
	public String successLogin (){

		return "redirect:/board/list";
	}
	
	
	@RequestMapping (value = "/signup", method =  RequestMethod.GET)
	public String getSignup (Model model, HttpServletRequest request){		
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);				
		
		return "/account/signup";
	}
	
	@RequestMapping (value = "/signup", method= RequestMethod.POST)
	public String postSignup (@Valid UserForm userForm, BindingResult result, HttpServletRequest request, Model model){		
		if(result.hasErrors()){			
			return "/account/signup";
		}		
		
		User user = new User();
		user.SetUser(userForm);
		userService.registerNewUserAccount(user);	
		request.removeAttribute("userForm");
		return "redirect:/user/login";
	}	
	
	@RequestMapping (value = "/reset")
	public String getReset (Model model){

		return "/account/reset";
	}
	
	@RequestMapping(value = "/logout")
	public String logout (HttpSession session, HttpServletRequest request){
		request.removeAttribute("userSession");
		session.invalidate();
		return "redirect:/board/list";
	}
	
	//회원가입 성공창
	//회원가입 후 재로그인 페이지
}

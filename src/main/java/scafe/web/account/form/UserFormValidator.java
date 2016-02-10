package scafe.web.account.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import scafe.service.UserService;

@Component
public class UserFormValidator implements Validator{

	public static final String KOREAN_PATTERN = "^[가-힣]*$";
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	public static final String EMAIL_PATTERN2 = "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String NUMBER_PATTERN = "[0-9]+";	
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserForm user = (UserForm) object;
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "field.required");
		
		if(!user.getPassword1().equals(user.getPassword2())){
			errors.rejectValue("password2", "field.password.equal");
		}else{
			user.setPassword(user.getPassword1());
			System.out.println(user.getPassword());
		}
		
		if(userService.emailExist(user.getEmail())){
			errors.rejectValue("email", "field.email.exist");
		}			
		
		if(!user.getEmail().matches(EMAIL_PATTERN)){
			errors.rejectValue("email", "field.email");
		}
	}	
}

package scafe.web.account.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import scafe.service.UserService;

@Component
public class LoginFormValidator implements Validator{

//	EncryptUtils encryptUtils = new EncryptUtils();
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LoginForm loginForm = (LoginForm) object;
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");

		int id = userService.getIdByUserEmail(loginForm.getEmail());
		
		if(id < 0){
			errors.rejectValue("email", "field.email.nonexist");
		}else{
			if( !passwordEncoder.matches(loginForm.getPassword(), userService.getOne(id).getPassword())){
				errors.rejectValue("password", "field.password.equal");
			}			
		}				
		
	}	
}

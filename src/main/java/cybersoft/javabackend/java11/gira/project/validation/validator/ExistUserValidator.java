package cybersoft.javabackend.java11.gira.project.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Optional;

import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistUser;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import cybersoft.javabackend.java11.gira.user.service.UserService;
import lombok.AllArgsConstructor;


public class ExistUserValidator implements ConstraintValidator<ExistUser, String>{
	
	@Autowired
	private UserService _userService;
	private String message ;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		boolean result = _userService.isTakenUsername(username);
		
		if (result)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		
		return false;
	}
	
	@Override
	public void initialize(ExistUser constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

}

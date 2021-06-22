package cybersoft.javabackend.java11.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java11.gira.role.service.RoleService;
import cybersoft.javabackend.java11.gira.role.validation.annotation.UniqueRolename;

public class UniqueRolenameValidator implements ConstraintValidator<UniqueRolename, String> {
	
	@Autowired
	private RoleService _service;
	private String message;
	@Override
	public void initialize (UniqueRolename constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String rolename, ConstraintValidatorContext context) {
		boolean isTakenRolename = _service.isTakenRolename(rolename);
		if (!isTakenRolename)
			return true;
		
		context.buildConstraintViolationWithTemplate(rolename)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}
}

package cybersoft.javabackend.java11.gira.project.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import cybersoft.javabackend.java11.gira.project.service.ProjectService;
import cybersoft.javabackend.java11.gira.project.validation.annotation.UniqueProjectCode;

public class UniqueProjectCodeValidator implements ConstraintValidator<UniqueProjectCode, String> {

	@Autowired
	private ProjectService _service;
	private String message ;
	

	@Override
	public boolean isValid(String projectCode, ConstraintValidatorContext context) {
		boolean istakenProjectCode =  _service.isTakenProjectCode(projectCode);
		
		if (!istakenProjectCode)
			return true;
		context.buildConstraintViolationWithTemplate(projectCode)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

	@Override
	public void initialize(UniqueProjectCode constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
}

package cybersoft.javabackend.java11.gira.project.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java11.gira.project.service.ProjectService;
import cybersoft.javabackend.java11.gira.project.validation.annotation.UniqueProjectName;


public class UniqueProjectNameValidator implements ConstraintValidator<UniqueProjectName, String> {
	@Autowired
	private ProjectService _projectService;
	private String message; 
	
	@Override
	public boolean isValid(String projectName, ConstraintValidatorContext context) {
		boolean result = _projectService.isTakenProjectName(projectName);
		
		if ( !result )
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		
		return false;
	}
	
	@Override
	public void initialize(UniqueProjectName constraintAnnotation) {
		this.message = constraintAnnotation.message();
		
	}

}

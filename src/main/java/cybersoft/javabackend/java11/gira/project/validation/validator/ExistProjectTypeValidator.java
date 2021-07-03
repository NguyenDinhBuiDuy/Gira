package cybersoft.javabackend.java11.gira.project.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java11.gira.project.service.ProjectTypeService;
import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistProjectType;

public class ExistProjectTypeValidator implements ConstraintValidator<ExistProjectType, Long>{

	@Autowired
	private ProjectTypeService _projectTypeService;
	private String message ;
	
	
	@Override
	public boolean isValid(Long id, ConstraintValidatorContext context) {
		boolean result = _projectTypeService.isTakenProjectType(id);
		
		if (result)
			
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		
		return false;
	}

}

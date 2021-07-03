package cybersoft.javabackend.java11.gira.project.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java11.gira.project.validation.validator.ExistUserValidator;

@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
@Constraint( validatedBy = ExistUserValidator.class)
public @interface ExistUser {
	public String message() default "The User is not Exist	";
	
	public Class <?>[] groups() default {};
	
	public Class <? extends Payload>[] payload() default{};
	
}

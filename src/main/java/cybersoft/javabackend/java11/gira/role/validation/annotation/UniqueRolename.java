package cybersoft.javabackend.java11.gira.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java11.gira.role.validation.validator.UniqueRolenameValidator;

@Constraint (validatedBy = UniqueRolenameValidator.class)
@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME) // quy dinh khi nao annotation co tac dung
public @interface UniqueRolename {
	public String message() default "Rolename is already used";
	
	public Class <?>[] groups() default {};
	
	public Class < ? extends Payload> [] payload() default{};
}

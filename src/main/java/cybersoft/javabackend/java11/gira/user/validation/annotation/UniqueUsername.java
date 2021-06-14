package cybersoft.javabackend.java11.gira.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java11.gira.user.validation.validator.UniqueUserNameValidator;

@Constraint (validatedBy = UniqueUserNameValidator.class)
@Target(ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME) // quy dinh khi nao annotation co tac dung
public @interface UniqueUsername {
	public String message() default "Username is already used";
	
	public Class <?>[] group() default {};
	
	public Class < ? extends Payload> [] payload() default{}	;
}

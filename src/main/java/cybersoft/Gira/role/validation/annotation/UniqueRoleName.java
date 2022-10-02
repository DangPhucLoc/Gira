package cybersoft.Gira.role.validation.annotation;

import cybersoft.Gira.role.validation.validator.UniqueRoleNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueRoleNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueRoleName {
    String message() default "Role name is existed";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };


}

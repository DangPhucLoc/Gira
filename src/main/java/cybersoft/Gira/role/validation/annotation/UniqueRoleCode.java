package cybersoft.Gira.role.validation.annotation;

import cybersoft.Gira.role.validation.validator.UniqueRoleCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueRoleCodeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueRoleCode {
    String message() default "Role code is existed.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

package cybersoft.Gira.role.validation.validator;

import cybersoft.Gira.role.model.Role;
import cybersoft.Gira.role.repository.RoleRepository;
import cybersoft.Gira.role.validation.annotation.UniqueRoleName;
import org.aspectj.bridge.IMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator
        <UniqueRoleName, String> {
    private String message;
    private final RoleRepository repository;

    public UniqueRoleNameValidator(RoleRepository roleRepository){
        this.repository = roleRepository;
    }

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Role> roleOpt = repository.findByName(name);

        if(roleOpt.isEmpty())
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }


}

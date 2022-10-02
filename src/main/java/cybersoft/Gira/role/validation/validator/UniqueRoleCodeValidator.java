package cybersoft.Gira.role.validation.validator;

import cybersoft.Gira.role.model.Role;
import cybersoft.Gira.role.repository.RoleRepository;
import cybersoft.Gira.role.validation.annotation.UniqueRoleCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleCodeValidator implements ConstraintValidator
                                    <UniqueRoleCode, String>{
    private String message;
    private final RoleRepository repository;

    public UniqueRoleCodeValidator(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueRoleCode constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Role roleOpt = repository.findByCode(code);
        if(roleOpt == null)
        return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

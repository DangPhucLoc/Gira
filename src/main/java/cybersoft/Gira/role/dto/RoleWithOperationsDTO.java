package cybersoft.Gira.role.dto;

import java.util.Set;
import java.util.UUID;

public class RoleWithOperationsDTO {
    private UUID id;

    private String name;

    private String code;

    private String description;

    private Set<OperationDTO> operations;
}

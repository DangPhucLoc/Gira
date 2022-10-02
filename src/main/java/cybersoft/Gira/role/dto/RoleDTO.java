package cybersoft.Gira.role.dto;

import cybersoft.Gira.role.validation.annotation.UniqueRoleName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

// data transfer object = dto
@Getter
@Setter
@Builder
public class RoleDTO {
    private UUID id;
    @Size(min = 5, max = 100, message = "{role.name.size}")
    @NotBlank
    @UniqueRoleName
    private String name;

    @Size(min = 3, max = 10, message = "{role.code.size}")
    @NotBlank
    private String code;

    @NotBlank(message = "{role.description.blank}")
    private String description;
}

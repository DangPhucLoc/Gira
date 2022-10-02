package cybersoft.Gira.user.dto;

import cybersoft.Gira.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private UUID id;
    private String accountName;
    private String password;
    private String email;
    private String userName;
    private String fullName;
    private User.status status;

}

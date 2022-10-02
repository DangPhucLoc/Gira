package cybersoft.Gira.user.boundary;

import cybersoft.Gira.common.util.ResponseUtils;
import cybersoft.Gira.user.dto.UserDTO;
import cybersoft.Gira.user.model.User;
import cybersoft.Gira.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestResource {
    private final UserService userService;

    public UserRestResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAllUser() {
        return ResponseUtils.get(
                userService.findAllDto(UserDTO.class),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> saveUser(UserDTO userDTO) {
        return ResponseUtils.get(
                userService.save(userDTO, User.class, UserDTO.class)
                ,HttpStatus.OK
        );
    };
}

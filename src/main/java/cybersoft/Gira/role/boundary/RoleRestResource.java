package cybersoft.Gira.role.boundary;

import cybersoft.Gira.role.model.Role;
import cybersoft.Gira.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleRestResource {
    private final RoleService service;

    public RoleRestResource(RoleService roleService) {
        this.service = roleService;
    }

    @GetMapping
    public Object findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public Object save(@RequestBody Role role) {
        return new ResponseEntity<>(service.save(role),HttpStatus.OK);
    }
}

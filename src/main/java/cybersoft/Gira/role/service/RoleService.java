package cybersoft.Gira.role.service;

import cybersoft.Gira.role.model.Role;
import cybersoft.Gira.role.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role update(Role role, String code);
    void delete(String code);
}
@Transactional
@Service
class RoleServiceImp implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImp(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role update(Role role, String code) {
        Role curRole = repository.findByCode(code);
        curRole.setName(role.getName());
        curRole.setDescription(role.getDescription());
        return repository.save(curRole);
    }

    @Override
    public void delete(String code) {
    repository.deleteByCode(code);
    }
}

package cybersoft.Gira.role.repository;

import cybersoft.Gira.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByCode(String code);
    Role deleteByCode(String code);

    Optional<Role> findByName(String name);
}

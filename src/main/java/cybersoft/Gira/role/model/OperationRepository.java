package cybersoft.Gira.role.model;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OperationRepository  extends JpaRepository<Operation, UUID>{
}

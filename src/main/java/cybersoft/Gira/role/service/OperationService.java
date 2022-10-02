package cybersoft.Gira.role.service;
import cybersoft.Gira.common.service.GenericService;
import cybersoft.Gira.role.dto.OperationDTO;
import cybersoft.Gira.role.model.Operation;
import cybersoft.Gira.role.model.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
public interface OperationService extends GenericService<Operation, OperationDTO, UUID> {

    List<Operation> findAll(List<UUID> operationIds);
}

@org.springframework.stereotype.Service
@Transactional
class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final ModelMapper modelMapper;

    OperationServiceImpl(OperationRepository operationRepository, ModelMapper modelMapper) {
        this.operationRepository = operationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JpaRepository<Operation, UUID> getRepository() {
        return operationRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return modelMapper;
    }

    @Override
    public List<Operation> findAll(List<UUID> operationIds) {
        return operationRepository.findAllById(operationIds);
    }
}

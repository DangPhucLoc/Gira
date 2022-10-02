package cybersoft.Gira.role.boundary;

import cybersoft.Gira.common.util.ResponseUtils;
import cybersoft.Gira.role.dto.OperationDTO;

import cybersoft.Gira.role.model.Operation;
import cybersoft.Gira.role.service.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/operations")
public class OperationRestResource {
    private final cybersoft.Gira.role.service.OperationService operationService;

    public OperationRestResource(OperationService operationService) {
        this.operationService = (cybersoft.Gira.role.service.OperationService) operationService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseUtils.get(operationService.findAllDto(OperationDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid OperationDTO dto) {
        return ResponseUtils.get(
                operationService.save(dto, Operation.class, OperationDTO.class)
                , HttpStatus.OK
        );
    }


}

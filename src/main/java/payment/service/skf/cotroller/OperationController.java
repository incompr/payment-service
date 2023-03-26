package payment.service.skf.cotroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment.service.skf.dto.AccountDTO;
import payment.service.skf.models.Operation;
import payment.service.skf.services.OperationService;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {


    private final OperationService operationService;
    private final ModelMapper modelMapper;

    @Autowired
    public OperationController(OperationService operationService, ModelMapper modelMapper) {
        this.operationService = operationService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/getOperationList")
    public List<Operation> getOperationList() {
        return operationService.findAll();
    }

    @GetMapping("/getOperationList/{id}")
    public List<Operation> getOperation(@PathVariable("id") int id) {
        return operationService.findOne(id);
    }

}

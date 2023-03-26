package payment.service.skf.cotroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.services.AccountService;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountInfo(@PathVariable("id") int id) throws AccountNotFoundException {
        return accountService.findOne(id);

    }

}

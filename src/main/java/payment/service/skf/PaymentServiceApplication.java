package payment.service.skf;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PaymentServiceApplication {

    //@Autowired
    //AccountRepository accountRepository;
    //@Autowired
    //OperationRepository operationRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
        //SpringApplication.run();

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



}



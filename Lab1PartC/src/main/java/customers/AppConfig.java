package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService(){
        CustomerService cs  = new CustomerService();
        cs.setCustomerDAO(customerDAO());
        cs.setEmailSender(emailSender());
        return cs;
    }

    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAO(logger());
    }

    @Bean
    public EmailSender emailSender(){
        return new EmailSender(logger());
    }

    @Bean
    public Logger logger(){
        return new Logger();
    }

}

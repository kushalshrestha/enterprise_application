package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        BankDTO accountCreate = new BankDTO("createAccount", 999, "Kushal Shrestha", 0.0);
        ObjectMapper objectMapper = new ObjectMapper();
        String accountCreateAsString = objectMapper.writeValueAsString(accountCreate);
        sender.send("BankTopic8", accountCreateAsString);
        System.out.println("Message has been sent to Bank Topic");

        BankDTO deposit = new BankDTO("deposit", 999, null, 1234);
        ObjectMapper objectMapper1 = new ObjectMapper();
        String depositAsString = objectMapper1.writeValueAsString(deposit);
        sender.send("BankTopic8", depositAsString);
        System.out.println("Message has been sent to Bank Topic");


        BankDTO withdraw = new BankDTO("withdraw", 999, null, 234);
        ObjectMapper objectMapper2 = new ObjectMapper();
        String withdrawAsString = objectMapper2.writeValueAsString(withdraw);
        sender.send("BankTopic8", withdrawAsString);
        System.out.println("Message has been sent to Bank Topic");







    }
}

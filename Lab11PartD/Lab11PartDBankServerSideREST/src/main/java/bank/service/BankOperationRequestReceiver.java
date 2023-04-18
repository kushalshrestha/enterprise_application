package bank.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BankOperationRequestReceiver {

    @Autowired
    private AccountService accountService;

    @KafkaListener(topics = {"BankTopic8"})
    public void receive(@Payload String bankdto) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(bankdto);
            String operation = actualObj.get("operation").textValue();
            long accountNumber = actualObj.get("accountNumber").longValue();
            String customerName = actualObj.get("customerName").textValue();
            double amount = actualObj.get("amount").doubleValue();

            switch (operation){
                case "createAccount":
                    accountService.createAccount(accountNumber, customerName);
                    break;
                case "deposit":
                    accountService.deposit(accountNumber, amount);
                    break;
                case "withdraw":
                    accountService.withdraw(accountNumber, amount);
                    break;
            }
            System.out.println("JMS receiver received message for operation : " + operation);

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + bankdto+" to a BankDTO object");
        }

    }
}

package jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class TaxServiceListener {
    @JmsListener(destination = "taxService")
    public void receiveMessage(final String taxServiceMessage) {
        System.out.println("JMS receiver received message:  " + taxServiceMessage);
    }
}

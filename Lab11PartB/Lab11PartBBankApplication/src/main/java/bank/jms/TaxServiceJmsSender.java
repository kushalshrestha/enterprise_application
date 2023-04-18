package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceJmsSender implements IJMSSender{

    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendJMSMessage(String text) {
        jmsTemplate.convertAndSend("taxService",text);
    }
}

package bank.jms;

import bank.service.TaxServiceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender{

	@Autowired
	JmsTemplate jmsTemplate;
	public void sendJMSMessage (String text){

		System.out.println("JMSSender: sending JMS message ="+text);



	}

}

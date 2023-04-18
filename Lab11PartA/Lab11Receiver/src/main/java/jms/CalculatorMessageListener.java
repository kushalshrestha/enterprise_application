package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorMessageListener {
    private long initial_number = 0;
    @JmsListener(destination = "calculatorQueue")
    public void receiveCalculatorMessage(final String jmsCalculatorAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JMSCalculator jmsCalculator = objectMapper.readValue(jmsCalculatorAsString, JMSCalculator.class);
            System.out.println("JMS receiver received message: NUMBER => " + jmsCalculator.getNumber()+"  AND OPERATOR RECEIVED => "+jmsCalculator.getOperator());

            long calculatedValue = 0;
            switch (jmsCalculator.getOperator()){
                case "+" :
                    calculatedValue =  initial_number + jmsCalculator.getNumber();
                    break;
                case "-" :
                    calculatedValue =  initial_number - jmsCalculator.getNumber();
                    break;
                case "*" :
                    calculatedValue =  initial_number * jmsCalculator.getNumber();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator sent");
            }
            initial_number = calculatedValue;
            System.out.println("OUTPUT : " + calculatedValue );

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + jmsCalculatorAsString+" to a JMSCalculator object");
        }
    }
}

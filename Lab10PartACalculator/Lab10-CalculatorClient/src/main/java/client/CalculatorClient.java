package client;

import generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CalculatorClient extends WebServiceGatewaySupport {

    public int multiply(int firstNumber, int secondNumber) {
        MultiplyRequest multiplyRequest = new MultiplyRequest();
        multiplyRequest.setNumber1(firstNumber);
        multiplyRequest.setNumber2(secondNumber);
        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(multiplyRequest);
        return  response.getResult();
    }
    public int add(int firstNumber, int secondNumber) {
        AddRequest addRequest = new AddRequest();
        addRequest.setNumber1(firstNumber);
        addRequest.setNumber2(secondNumber);
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(addRequest);
        return  response.getResult();
    }
    public int subtract(int firstNumber, int secondNumber) {
        SubtractRequest subtractRequest = new SubtractRequest();
        subtractRequest.setNumber1(firstNumber);
        subtractRequest.setNumber2(secondNumber);
        SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(subtractRequest);
        return  response.getResult();
    }
}

package bank.service;

import java.util.Map;

public class CustomMessage {
    private String message;
    private Map<String, Object> responseObject;

    public CustomMessage(String message) {
        this.message = message;
    }

    public CustomMessage(String message, Map<String, Object> responseObject) {
        this.message = message;
        this.responseObject = responseObject;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Map<String, Object> responseObject) {
        this.responseObject = responseObject;
    }
}


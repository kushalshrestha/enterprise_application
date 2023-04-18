package bank.service;

import bank.domain.Account;

public class TaxServiceDTO {
    private String messageDetails;

    protected TaxServiceDTO(){}

    public TaxServiceDTO(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    @Override
    public String toString() {
        return "TaxServiceDTO{" +
                "messageDetails='" + messageDetails + '\'' +
                '}';
    }
}

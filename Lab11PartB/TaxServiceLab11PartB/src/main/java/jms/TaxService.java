package jms;

public class TaxService {
    private String messageDetails;

    protected TaxService(){}

    public TaxService(String messageDetails) {
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
        return "TaxService{" +
                "messageDetails='" + messageDetails + '\'' +
                '}';
    }
}

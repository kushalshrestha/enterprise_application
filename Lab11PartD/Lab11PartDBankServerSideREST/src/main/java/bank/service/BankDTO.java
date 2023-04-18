package bank.service;

public class BankDTO {
    private String operation;
    private long accountNumber;
    private String customerName;
    private double amount;

    protected BankDTO(){}

//    public BankDTO(String operation, long accountNumber, String customerName) {
//        this.operation = operation;
//        this.accountNumber = accountNumber;
//        this.customerName = customerName;
//    }
//
//    public BankDTO(String operation, long accountNumber, double amount) {
//        this.operation = operation;
//        this.accountNumber = accountNumber;
//        this.amount = amount;
//    }

    public BankDTO(String operation, long accountNumber, String customerName, double amount) {
        this.operation = operation;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "operation='" + operation + '\'' +
                ", accountNumber=" + accountNumber +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}

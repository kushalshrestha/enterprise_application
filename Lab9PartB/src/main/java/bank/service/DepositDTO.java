package bank.service;

public class DepositDTO {
    private long accountNumber;

    private double amount;

    public DepositDTO(long accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

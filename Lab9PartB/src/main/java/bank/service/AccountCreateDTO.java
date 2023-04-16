package bank.service;

public class AccountCreateDTO {
    private long accountnumber;
    private String accountName;

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "AccountCreateDTO{" +
                "accountnumber=" + accountnumber +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}

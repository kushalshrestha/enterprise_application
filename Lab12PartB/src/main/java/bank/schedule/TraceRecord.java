package bank.schedule;

import org.springframework.context.ApplicationEvent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="trace_record")
public class TraceRecord extends ApplicationEvent {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dateTime;
    private long accountNumber;
    private String operation;
    private double amount;

    public TraceRecord(long accountNumber, String operation , double amount){
        super(operation);
        this.dateTime = LocalDateTime.now();
        this.accountNumber = accountNumber;
        this.operation = "OPERATION PERFORMED : " + operation;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountChangeEvent{" +
                "dateTime=" + dateTime +
                ", accountNumber=" + accountNumber +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                '}';
    }
}

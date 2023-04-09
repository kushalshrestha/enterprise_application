package bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime created_at;
    private String message;

    protected TraceRecord(){}

    public TraceRecord(LocalDateTime created_at, String message) {
        this.created_at = created_at;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TraceRecord{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", message='" + message + '\'' +
                '}';
    }
}

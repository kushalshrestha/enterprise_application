package bank.service.messaging;

import bank.schedule.TraceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import bank.repository.TraceRecordRepository;

@Service
public class AccountChangeEventListener {
    @Autowired
    TraceRecordRepository traceRecordRepository;

    @EventListener
    public void onEvent(TraceRecord event){
        System.out.println("ACCOUNTNUMBER: " + event.getAccountNumber() + " | OPERATION : " + event.getOperation() +
                " | AMOUNT : " + event.getAmount() + " | DATETIME : " + event.getDateTime());
        traceRecordRepository.save(event);
    }
}

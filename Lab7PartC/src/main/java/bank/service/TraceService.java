package bank.service;

import bank.domain.TraceRecord;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TraceService {

    @Autowired
    private TraceRecordRepository traceRecordRepository;

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public void saveTraceRecord(TraceRecord t){
        traceRecordRepository.save(t);
    };
}

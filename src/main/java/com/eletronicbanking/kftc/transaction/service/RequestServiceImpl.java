package com.eletronicbanking.kftc.transaction.service;

import com.eletronicbanking.kftc.transaction.repository.ReceiveRepository;
import com.eletronicbanking.kftc.transaction.repository.SendRepository;
import com.eletronicbanking.kftc.transaction.table.Receive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

    @Autowired
    ReceiveRepository receiveRepository;
    @Autowired
    SendRepository sendRepository;
    @Autowired
    KafkaProducer kafkaProducer;

    private static Map<Long,String> hashMap = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public String findName(String accountNumber) {

        Receive data = new Receive();

        data.setDate("20220331");
        data.setComTypeCode("type");
        data.setComBizCode("biz");
        hashMap.put(sequence, accountNumber);
        data.setComNumber(++sequence);
        data.setComContext(accountNumber);

        // 결제원갔다와야함
        receiveRepository.save(data); //insert db
        log.info("insert db");

        // kafka produce
        String message = accountNumber + " test : " + sequence;
        kafkaProducer.sendMessage(message);

        return accountNumber;
    }
}

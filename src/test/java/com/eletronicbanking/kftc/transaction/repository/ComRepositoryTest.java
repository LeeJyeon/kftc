package com.eletronicbanking.kftc.transaction.repository;

import com.eletronicbanking.kftc.transaction.table.ComId;
import com.eletronicbanking.kftc.transaction.table.Receive;
import com.eletronicbanking.kftc.transaction.table.Send;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Slf4j
class ComRepositoryTest {

    @Autowired
    ReceiveRepository receiveRepository;
    @Autowired
    SendRepository sendRepository;

    @Test
    void simpleSaveReceive() {
        Receive data = new Receive();

        data.setDate("20220206");
        data.setComTypeCode("type");
        data.setComBizCode("biz");
        data.setComNumber(1L);
        data.setComContext("context");

        receiveRepository.save(data);

        ComId dataKey = new ComId("20220206", "type", "biz", 1L);

        Optional<Receive> findData = receiveRepository.findById(dataKey);
//        log.info( findData.toString() );
        Assertions.assertEquals(data.getComNumber(),findData.get().getComNumber());
    }


    @Test
    void simpleSaveSend() {
        Send data = new Send();

        data.setDate("20220206");
        data.setComTypeCode("type");
        data.setComBizCode("biz");
        data.setComNumber(1L);
        data.setComContext("context");

        sendRepository.save(data);

        ComId dataKey = new ComId("20220206", "type", "biz", 1L);

        Optional<Send> findData = sendRepository.findById(dataKey);
//        log.info( findData.toString() );
        Assertions.assertEquals(data.getComNumber(),findData.get().getComNumber());
    }
}
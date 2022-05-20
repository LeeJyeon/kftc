package com.eletronicbanking.kftc.transaction.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void receiveMessage(String message) {
        log.info("[Test] Kafka Consumer message : {}" , message);
    }
}
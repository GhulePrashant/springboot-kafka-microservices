package com.prashantghule.emailservice.kafka;

import com.prashantghule.domainservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailKafkaConsumer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.name}")
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("EmailService consume() Order Event -> %s", orderEvent.toString()));
    }

}

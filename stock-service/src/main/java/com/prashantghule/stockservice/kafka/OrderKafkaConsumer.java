package com.prashantghule.stockservice.kafka;

import com.prashantghule.domainservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderKafkaConsumer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.name}")
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("StockService Consume() Order Event -> %s",orderEvent.toString()));

        // save eventData in DB -- I'll do in future
    }

}

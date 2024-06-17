package com.RkExample.emailservice.kafka;

import com.RkExample.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",topics = "${spring.kafka.topic.name}")
    public void consume(OrderEvent orderEvent){
        logger.info(String.format("OrderEvent Consumed in Email Service ==-> %s",orderEvent.toString()));

      // email logic here
    }
}

package com.RKexample.springBoot;

import com.RKexample.springBoot.entity.WikimediaData;
import com.RKexample.springBoot.repository.WikimediaDataRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class kafkaDatabaseConsumer {
    private static final Logger logger = LoggerFactory.getLogger(kafkaDatabaseConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    public kafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository){
        this.wikimediaDataRepository = wikimediaDataRepository;
    }
     @KafkaListener(topics = "wikimedia_recentchange",
     groupId = "myGroup")
    public void consume(String eventMessage){

         logger.info(String.format("Event Message Received,%s",eventMessage));
         String alteredMessage = eventMessage.substring(1,100);
         WikimediaData wikimediaData = new WikimediaData();
         wikimediaData.setWikiEventData(alteredMessage);
         wikimediaDataRepository.save(wikimediaData);
    }
}

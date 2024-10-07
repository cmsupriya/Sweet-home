package com.booking.services;

import com.booking.config.KafkaMessageProducer;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
   @Autowired
   private KafkaMessageProducer kafkaMessageProducer;

   public MessageServiceImpl() {
   }

   public void produceMessage(String topicName, String key, String value) throws IOException {
      this.kafkaMessageProducer.publish(topicName, key, value);
   }
}

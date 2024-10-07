package com.booking.services;

import java.io.IOException;

public interface MessageService {
   void produceMessage(String topicName, String key, String value) throws IOException;
}
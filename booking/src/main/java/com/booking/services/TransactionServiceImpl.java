package com.booking.services;

import com.booking.dto.PaymentDTO;
import com.booking.dto.TransactionIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServiceImpl implements TransactionService {
   @Autowired
   private RestTemplate restTemplate;

   public TransactionServiceImpl() {
   }

   public int getTransactionNumber(PaymentDTO paymentDTO) {
      String paymentUri = "http://localhost:8083/transaction";
      TransactionIdDTO transactionIdDTO = (TransactionIdDTO)this.restTemplate.postForObject(paymentUri, paymentDTO, TransactionIdDTO.class, new Object[0]);
      return transactionIdDTO == null ? 0 : transactionIdDTO.getTransactionId();
   }
}
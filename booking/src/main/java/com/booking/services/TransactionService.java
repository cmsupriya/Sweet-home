package com.booking.services;

import com.booking.dto.PaymentDTO;

public interface TransactionService {
   int getTransactionNumber(PaymentDTO paymentDTO);
}

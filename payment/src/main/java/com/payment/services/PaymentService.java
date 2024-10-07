package com.payment.services;

import com.payment.entity.TransactionDetailsEntity;

import java.util.List;

public interface PaymentService {

    public TransactionDetailsEntity saveTransaction(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getTransaction(int id);

    public List<TransactionDetailsEntity> getAllTransactions();
}

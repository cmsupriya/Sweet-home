package com.payment.dao;

import com.payment.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<TransactionDetailsEntity, Integer> {

}

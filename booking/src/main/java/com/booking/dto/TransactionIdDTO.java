package com.booking.dto;

import java.util.Objects;

public class TransactionIdDTO {
   private int transactionId;

   public TransactionIdDTO(int transactionId) {
      this.transactionId = transactionId;
   }

   public TransactionIdDTO() {
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         TransactionIdDTO that = (TransactionIdDTO)o;
         return this.transactionId == that.transactionId;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.transactionId});
   }

   public String toString() {
      return "TransactionIdDTO{transactionId=" + this.transactionId + '}';
   }

   public int getTransactionId() {
      return this.transactionId;
   }

   public void setTransactionId(int transactionId) {
      this.transactionId = transactionId;
   }
}

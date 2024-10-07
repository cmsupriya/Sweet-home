package com.booking.dto;

import java.util.Objects;

public class PaymentDTO {
   private int bookingId;
   private String upiId;
   private String paymentMode;
   private String cardNumber;

   public PaymentDTO(int bookingId, String upiId, String paymentMode, String cardNumber) {
      this.bookingId = bookingId;
      this.upiId = upiId;
      this.paymentMode = paymentMode;
      this.cardNumber = cardNumber;
   }

   public PaymentDTO() {
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         PaymentDTO that = (PaymentDTO)o;
         return this.bookingId == that.bookingId && this.upiId == that.upiId && Objects.equals(this.paymentMode, that.paymentMode) && Objects.equals(this.cardNumber, that.cardNumber);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.bookingId, this.upiId, this.paymentMode, this.cardNumber});
   }

   public String toString() {
      return "PaymentDTO{bookingId=" + this.bookingId + ", upiId=" + this.upiId + ", paymentMode='" + this.paymentMode + '\'' + ", cardNumber='" + this.cardNumber + '\'' + '}';
   }

   public int getBookingId() {
      return this.bookingId;
   }

   public void setBookingId(int bookingId) {
      this.bookingId = bookingId;
   }

   public String getUpiId() {
      return this.upiId;
   }

   public void setUpiId(String upiId) {
      this.upiId = upiId;
   }

   public String getPaymentMode() {
      return this.paymentMode;
   }

   public void setPaymentMode(String paymentMode) {
      this.paymentMode = paymentMode;
   }

   public String getCardNumber() {
      return this.cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }
}

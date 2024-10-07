package com.booking.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class BookingInfoDTO {
   private int id;
   private String fromDate;
   private String toDate;
   private String bookedOn;
   private String aadharNumber;
   private String roomNumbers;
   private int numOfRooms;
   private int roomPrice;
   private int transactionId;

   public BookingInfoDTO(int id, String fromDate, String toDate, String aadharNumber, int numOfRooms) {
      this.id = id;
      this.fromDate = fromDate;
      this.toDate = toDate;
      this.aadharNumber = aadharNumber;
      this.numOfRooms = numOfRooms;
      this.bookedOn = "2021-07-01";
      this.transactionId = 0;
      this.roomPrice = getTotalRoomPrice(numOfRooms, fromDate, toDate);
      this.roomNumbers = getRandomRoomNumbers(numOfRooms);
   }

   public BookingInfoDTO() {
   }

   public static int getTotalRoomPrice(int numOfRooms, String fromDate, String toDate) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
      LocalDate from = LocalDate.parse(fromDate, formatter);
      LocalDate to = LocalDate.parse(toDate, formatter);
      Period period = Period.between(from, to);
      int numDays = period.getDays();
      return 1000 * numDays * numOfRooms;
   }

   public static String getRandomRoomNumbers(int count) {
      Random rand = new Random();
      int upperBound = 100;
      ArrayList<String> numberList = new ArrayList();

      for(int i = 0; i < count; ++i) {
         numberList.add(String.valueOf(rand.nextInt(upperBound)));
      }

      return String.join(",", numberList);
   }

   public String toString() {
      return "BookingDTO{id=" + this.id + ", fromDate='" + this.fromDate + '\'' + ", toDate='" + this.toDate + '\'' + ", bookedOn='" + this.bookedOn + '\'' + ", aadharNumber='" + this.aadharNumber + '\'' + ", roomNumbers='" + this.roomNumbers + '\'' + ", numOfRooms=" + this.numOfRooms + ", roomPrice=" + this.roomPrice + ", transactionId=" + this.transactionId + '}';
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         BookingInfoDTO that = (BookingInfoDTO)o;
         return this.id == that.id && this.numOfRooms == that.numOfRooms && this.roomPrice == that.roomPrice && this.transactionId == that.transactionId && Objects.equals(this.fromDate, that.fromDate) && Objects.equals(this.toDate, that.toDate) && Objects.equals(this.bookedOn, that.bookedOn) && Objects.equals(this.aadharNumber, that.aadharNumber) && Objects.equals(this.roomNumbers, that.roomNumbers);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.id, this.fromDate, this.toDate, this.bookedOn, this.aadharNumber, this.roomNumbers, this.numOfRooms, this.roomPrice, this.transactionId});
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getFromDate() {
      return this.fromDate;
   }

   public void setFromDate(String fromDate) {
      this.fromDate = fromDate;
   }

   public String getToDate() {
      return this.toDate;
   }

   public void setToDate(String toDate) {
      this.toDate = toDate;
   }

   public String getBookedOn() {
      return this.bookedOn;
   }

   public void setBookedOn(String bookedOn) {
      this.bookedOn = bookedOn;
   }

   public String getAadharNumber() {
      return this.aadharNumber;
   }

   public void setAadharNumber(String aadharNumber) {
      this.aadharNumber = aadharNumber;
   }

   public String getRoomNumbers() {
      return this.roomNumbers;
   }

   public void setRoomNumbers(String roomNumbers) {
      this.roomNumbers = roomNumbers;
   }

   public int getNumOfRooms() {
      return this.numOfRooms;
   }

   public void setNumOfRooms(int numOfRooms) {
      this.numOfRooms = numOfRooms;
   }

   public int getRoomPrice() {
      return this.roomPrice;
   }

   public void setRoomPrice(int roomPrice) {
      this.roomPrice = roomPrice;
   }

   public int getTransactionId() {
      return this.transactionId;
   }

   public void setTransactionId(int transactionId) {
      this.transactionId = transactionId;
   }
}

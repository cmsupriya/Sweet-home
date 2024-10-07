package com.booking.services;

import com.booking.dao.BookingDAO;
import com.booking.entity.BookingInfoEntity;
import com.booking.exceptions.PaymentException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
   @Autowired
   public BookingDAO _bookingDAO;

   public BookingServiceImpl() {
   }

   public BookingInfoEntity saveBooking(BookingInfoEntity booking) {
      return (BookingInfoEntity)this._bookingDAO.save(booking);
   }

   public BookingInfoEntity getBooking(int id) {
      Optional<BookingInfoEntity> obj = this._bookingDAO.findById(id);
      if (!obj.isPresent()) {
         throw new PaymentException(" Invalid Booking Id ", 400);
      } else {
         return (BookingInfoEntity)obj.get();
      }
   }

   public List<BookingInfoEntity> getAllBookings() {
      return this._bookingDAO.findAll();
   }
}
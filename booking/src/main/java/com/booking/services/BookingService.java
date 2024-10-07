package com.booking.services;

import com.booking.entity.BookingInfoEntity;
import java.util.List;

public interface BookingService {
   BookingInfoEntity saveBooking(BookingInfoEntity booking);

   BookingInfoEntity getBooking(int id);

   List<BookingInfoEntity> getAllBookings();
}
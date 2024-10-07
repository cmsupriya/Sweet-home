package com.booking.dao;

import com.booking.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDAO extends JpaRepository<BookingInfoEntity, Integer> {
}
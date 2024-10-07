package com.booking.controller;

import com.booking.dto.BookingInfoDTO;
import com.booking.dto.PaymentDTO;
import com.booking.entity.BookingInfoEntity;
import com.booking.exceptions.PaymentException;
import com.booking.services.BookingService;
import com.booking.services.MessageService;
import com.booking.services.TransactionService;
import java.io.IOException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/"})
public class BookingController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ModelMapper modelMapper;

    public BookingController() {
    }

    @PostMapping(
        value = {"booking"},
        consumes = {"application/json"},
        produces = {"application/json"}
    )
    public ResponseEntity newBooking(@RequestBody BookingInfoDTO inputDTO) {
        BookingInfoEntity bookingInfo = new BookingInfoEntity(inputDTO.getFromDate(), inputDTO.getToDate(), inputDTO.getAadharNumber(), inputDTO.getNumOfRooms());
        BookingInfoEntity savedBooking = this.bookingService.saveBooking(bookingInfo);
        BookingInfoDTO savedBookingDTO = (BookingInfoDTO)this.modelMapper.map(savedBooking, BookingInfoDTO.class);
        return new ResponseEntity(savedBookingDTO, HttpStatus.OK);
    }

    @PostMapping(
        value = {"booking/{bookingId}/transaction"},
        consumes = {"application/json"},
        produces = {"application/json"}
    )
    public ResponseEntity completeTransaction(@RequestBody PaymentDTO paymentDTO, @PathVariable(name = "bookingId") int bookingId) throws IOException {
        if (!paymentDTO.getPaymentMode().equalsIgnoreCase("card") && !paymentDTO.getPaymentMode().equalsIgnoreCase("upi")) {
            throw new PaymentException("Invalid mode of payment", 400);
        } else {
            BookingInfoEntity bookingInfo = this.bookingService.getBooking(bookingId);
            if (bookingInfo == null) {
                throw new PaymentException(" Invalid Booking Id ", 400);
            } else {
                int transactionNumber = this.transactionService.getTransactionNumber(paymentDTO);
                bookingInfo.setTransactionId(transactionNumber);
                BookingInfoEntity updatedBookingInfo = this.bookingService.saveBooking(bookingInfo);
                String message = "Booking confirmed for user with aadhaar number: " + bookingInfo.getAadharNumber() + "    |    Here are the booking details:    " + bookingInfo.toString();
                this.messageService.produceMessage("message", "123AAA", message);
                BookingInfoDTO bookingInfoDTO = (BookingInfoDTO)this.modelMapper.map(updatedBookingInfo, BookingInfoDTO.class);
                return new ResponseEntity(bookingInfoDTO, HttpStatus.OK);
            }
        }
    }

    @GetMapping(
        value = {"bookings"},
        produces = {"application/json"}
    )
    public ResponseEntity fetchAllBookings() {
        List<BookingInfoEntity> bookingInfoList = this.bookingService.getAllBookings();
        return new ResponseEntity(bookingInfoList, HttpStatus.OK);
    }

    @GetMapping({"booking/{id}"})
    public ResponseEntity fetchBookingOnId(@PathVariable(name = "id") int id) {
        BookingInfoEntity bookingInfo = this.bookingService.getBooking(id);
        BookingInfoDTO bookingDTO = (BookingInfoDTO)this.modelMapper.map(bookingInfo, BookingInfoDTO.class);
        return new ResponseEntity(bookingDTO, HttpStatus.OK);
    }
}

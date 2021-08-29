package com.upgrad.bookingservice.services;


import com.upgrad.bookingservice.dto.PaymentDetailsDTO;
import com.upgrad.bookingservice.entities.BookingInfoEntity;

import java.util.List;

public interface BookingService {

    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfoEntity);

    public BookingInfoEntity getBookingDetailsById(int id);

    public List<BookingInfoEntity> getAllBookings();

    public BookingInfoEntity updateBooking(BookingInfoEntity bookingInfoEntity);

    public boolean deleteBooking(int id);

    public BookingInfoEntity acceptPayment(int bookingId, PaymentDetailsDTO paymentDetailsDTO);

}

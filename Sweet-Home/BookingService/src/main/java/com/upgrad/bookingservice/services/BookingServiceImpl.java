package com.upgrad.bookingservice.services;

import com.upgrad.bookingservice.dao.BookingDAO;
import com.upgrad.bookingservice.dto.PaymentDetailsDTO;
import com.upgrad.bookingservice.entities.BookingInfoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService{

    @Value("${paymentService.url}")
    private String paymentServiceUrl;

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfoEntity)
    {
        int period = Period.
                between(bookingInfoEntity.getFromDate(),bookingInfoEntity.getToDate()).getDays();
        int roomPrice = 1000* bookingInfoEntity.getNumOfRooms()*(period);
        bookingInfoEntity.setRoomPrice(roomPrice);

        ArrayList<String> roomNumbers=getRandomNumbers(bookingInfoEntity.getNumOfRooms());
        bookingInfoEntity.setRoomNumbers(roomNumbers.toString());

        bookingInfoEntity.setTransactionId(0);
        bookingInfoEntity.setBookedOn(LocalDateTime.now());

        BookingInfoEntity savedBooking=bookingDAO.save(bookingInfoEntity);
        return savedBooking;
    }

    @Override
    public BookingInfoEntity getBookingDetailsById(int id)
    {
        return bookingDAO.findById(id).get();
    }

    @Override
    public List<BookingInfoEntity> getAllBookings() {
        return bookingDAO.findAll();
    }

    @Override
    public BookingInfoEntity updateBooking(BookingInfoEntity bookingInfoEntity) {
        BookingInfoEntity savedBooking=getBookingDetailsById(bookingInfoEntity.getBookingId());
        savedBooking.setFromDate(bookingInfoEntity.getFromDate());
        savedBooking.setToDate(bookingInfoEntity.getToDate());
        savedBooking.setNumOfRooms(bookingInfoEntity.getNumOfRooms());
        int period = Period.
                between(bookingInfoEntity.getFromDate(),bookingInfoEntity.getToDate()).getDays();
        int roomPrice = 1000* bookingInfoEntity.getNumOfRooms()*(period);
        savedBooking.setRoomPrice(roomPrice);
        ArrayList<String> roomNumbers=getRandomNumbers(bookingInfoEntity.getNumOfRooms());
        savedBooking.setRoomNumbers(roomNumbers.toString());
        savedBooking.setRoomNumbers(bookingInfoEntity.getRoomNumbers());
        savedBooking.setAadharNumber(bookingInfoEntity.getAadharNumber());
        savedBooking.setTransactionId(bookingInfoEntity.getTransactionId());
        bookingDAO.save(savedBooking);
        return savedBooking;
    }

    @Override
    public boolean deleteBooking(int id) {
        BookingInfoEntity bookingInfoEntity=getBookingDetailsById(id);
        if(bookingInfoEntity==null){
            return false;
        }
        bookingDAO.delete(bookingInfoEntity);
        return true;
    }



    @Override
    public BookingInfoEntity acceptPayment(int bookingId,PaymentDetailsDTO paymentDetailsDTO) {
        BookingInfoEntity bookingInfoEntity=getBookingDetailsById(bookingId);
        if(bookingInfoEntity.getTransactionId()==0) {
            paymentDetailsDTO.setBookingId(bookingId);
            //Rest template for payment service
            System.out.println(paymentDetailsDTO.toString());
            Integer transactionId = restTemplate.postForObject(paymentServiceUrl, paymentDetailsDTO, Integer.class);
            bookingInfoEntity.setTransactionId(transactionId);
            bookingDAO.save(bookingInfoEntity);
        }
        return bookingInfoEntity;
    }

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }
}

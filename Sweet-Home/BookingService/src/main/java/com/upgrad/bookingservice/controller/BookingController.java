package com.upgrad.bookingservice.controller;

import com.upgrad.bookingservice.dto.BookingInfoDTO;
import com.upgrad.bookingservice.dto.PaymentDetailsDTO;
import com.upgrad.bookingservice.entities.BookingInfoEntity;
import com.upgrad.bookingservice.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/hotel")
public class BookingController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private BookingService bookingService;

    @PostMapping(value="/booking",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingInfoDTO> createBooking(@RequestBody BookingInfoDTO bookingInfoDTO){
        BookingInfoEntity bookingInfoEntity=modelMapper.map(bookingInfoDTO,BookingInfoEntity.class);
        BookingInfoEntity savedBooking=bookingService.acceptBookingDetails(bookingInfoEntity);
        BookingInfoDTO savedBookingInfoDTO=modelMapper.map(savedBooking,BookingInfoDTO.class);
        return new ResponseEntity(savedBookingInfoDTO, HttpStatus.CREATED);
    }

    @PostMapping(value="/booking/{id}/transaction",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingInfoDTO> createPayment(@PathVariable(name="id") int id,@RequestBody PaymentDetailsDTO paymentDetailsDTO)
    {
        BookingInfoEntity savedBookingInfoEntity=bookingService.acceptPayment(id,paymentDetailsDTO);
        BookingInfoDTO savedBookingInfoDTO=modelMapper.map(savedBookingInfoEntity,BookingInfoDTO.class);
        return new ResponseEntity(savedBookingInfoDTO,HttpStatus.OK);
    }

    @GetMapping(value="/booking/{id}")
    public ResponseEntity<BookingInfoDTO> getBookingById(@PathVariable(name="id")int id){
        BookingInfoEntity bookingInfoEntity=bookingService.getBookingDetailsById(id);
        BookingInfoDTO bookingInfoDTO=modelMapper.map(bookingInfoEntity,BookingInfoDTO.class);
        return new ResponseEntity(bookingInfoDTO,HttpStatus.OK);
    }

    @GetMapping(value="/booking/all")
    public ResponseEntity<List<BookingInfoDTO>> getAllBookings(){
        List<BookingInfoEntity> bookingInfoEntityList=bookingService.getAllBookings();
        List<BookingInfoDTO> bookingInfoDTOList=new ArrayList<>();
        for(BookingInfoEntity bookingInfoEntity:bookingInfoEntityList){
            bookingInfoDTOList.add(modelMapper.map(bookingInfoEntity,BookingInfoDTO.class));
        }
        return new ResponseEntity(bookingInfoDTOList,HttpStatus.OK);
    }

    @PutMapping(value="/booking")
    public ResponseEntity<BookingInfoDTO> updateBooking(@RequestBody BookingInfoDTO bookingInfoDTO){
        return null;
    }

    @DeleteMapping(value="/booking/{id}")
    public ResponseEntity deleteBooking(@PathVariable(name="id") int id){
        return null;
    }
}

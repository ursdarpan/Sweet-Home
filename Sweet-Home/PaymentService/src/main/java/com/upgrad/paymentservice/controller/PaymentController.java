package com.upgrad.paymentservice.controller;

import com.upgrad.paymentservice.dto.TransactionDetailsDTO;
import com.upgrad.paymentservice.entities.TransactionDetailsEntity;
import com.upgrad.paymentservice.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value="/transaction")
    public ResponseEntity<Integer> createPaymentTransaction(@RequestBody TransactionDetailsDTO transactionDetailsDTO){
        TransactionDetailsEntity transactionDetailsEntity=modelMapper.map(transactionDetailsDTO,TransactionDetailsEntity.class);
        TransactionDetailsEntity savedTransaction=paymentService.acceptPaymentDetails(transactionDetailsEntity);
        TransactionDetailsDTO savedTransactionDTO=modelMapper.map(savedTransaction,TransactionDetailsDTO.class);
        return new ResponseEntity(savedTransactionDTO.getTransactionId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/transaction/{id}")
    public ResponseEntity getTransactionById(@PathVariable(name="id") int id){
        TransactionDetailsEntity transactionDetailsEntity=paymentService.getPaymentDetailsById(id);
        TransactionDetailsDTO transactionDetailsDTO = modelMapper.map(transactionDetailsEntity,TransactionDetailsDTO.class);
        return new ResponseEntity(transactionDetailsDTO,HttpStatus.OK);
    }

}

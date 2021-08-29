package com.upgrad.paymentservice.services;

import com.upgrad.paymentservice.dao.TransactionDAO;
import com.upgrad.paymentservice.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    TransactionDAO transactionDAO;

    @Override
    public TransactionDetailsEntity acceptPaymentDetails(TransactionDetailsEntity transactionDetailsEntity) {
        return transactionDAO.save(transactionDetailsEntity);
    }

    @Override
    public TransactionDetailsEntity getPaymentDetailsById(int id) {
        return transactionDAO.findById(id).get();
    }

    @Override
    public List<TransactionDetailsEntity> getAllTransactions() {
        return transactionDAO.findAll();
    }

    @Override
    public TransactionDetailsEntity updatePaymentTransaction(int id,TransactionDetailsEntity transactionDetailsEntity) {
        TransactionDetailsEntity savedTransaction=this.getPaymentDetailsById(id);
        savedTransaction.setPaymentMode(transactionDetailsEntity.getPaymentMode());
        savedTransaction.setBookingId(transactionDetailsEntity.getBookingId());
        savedTransaction.setCardNumber(transactionDetailsEntity.getCardNumber());
        savedTransaction.setUpiId(transactionDetailsEntity.getUpiId());
        return transactionDAO.save(savedTransaction);
    }

    @Override
    public boolean deletePaymentTransaction(int id) {
        TransactionDetailsEntity transactionDetailsEntity=this.getPaymentDetailsById(id);
        if(transactionDetailsEntity == null){
            return false;
        }
        transactionDAO.delete(transactionDetailsEntity);
        return true;
    }
}

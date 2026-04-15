package com.mobileprepaid.backend.Service;

import com.mobileprepaid.backend.Dto.*;
import com.mobileprepaid.backend.Model.Transaction;
import com.mobileprepaid.backend.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeService {

    @Autowired
    private TransactionRepository transactionRepository;

    public RechargeResponse recharge(RechargeRequest request) {

        Transaction txn = Transaction.builder()
                .phone(request.getPhone())
                .operator(request.getOperator())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .status("SUCCESS")
                .build();

        transactionRepository.save(txn);

        return RechargeResponse.builder()
                .success(true)
                .message("Recharge Successful")
                .build();
    }
}
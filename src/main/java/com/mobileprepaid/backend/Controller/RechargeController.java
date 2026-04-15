package com.mobileprepaid.backend.Controller;

import com.mobileprepaid.backend.Dto.*;
import com.mobileprepaid.backend.Model.Transaction;
import com.mobileprepaid.backend.Repository.TransactionRepository;
import com.mobileprepaid.backend.Service.RechargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/recharge")
    public RechargeResponse recharge(@RequestBody RechargeRequest request) {
        return rechargeService.recharge(request);
    }

    @GetMapping("/recharge/history/{phone}")
    public List<Transaction> history(@PathVariable String phone) {
        return transactionRepository.findByPhoneOrderByCreatedAtDesc(phone);
    }
}
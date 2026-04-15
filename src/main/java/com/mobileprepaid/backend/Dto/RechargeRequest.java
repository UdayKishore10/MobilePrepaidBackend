package com.mobileprepaid.backend.Dto;

import lombok.Data;

@Data
public class RechargeRequest {

    private String phone;
    private String operator;
    private double amount;
    private String paymentMethod;
}
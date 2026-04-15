package com.mobileprepaid.backend.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RechargeResponse {

    private boolean success;
    private String message;
}
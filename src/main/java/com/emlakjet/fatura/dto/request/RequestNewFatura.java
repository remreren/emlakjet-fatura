package com.emlakjet.fatura.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestNewFatura {
    String firstName;
    String lastName;
    String email;
    BigDecimal amount;
    String productName;
}

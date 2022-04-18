package com.emlakjet.fatura.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestNewFatura {
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal amount;
    private String productName;
}

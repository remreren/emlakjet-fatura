package com.emlakjet.fatura.exception;

import java.math.BigDecimal;

public class SumOfPSFaturasExceededLimit extends IllegalArgumentException {
    public SumOfPSFaturasExceededLimit(BigDecimal sumBefore, BigDecimal amount, BigDecimal limit) {
        super(String.format("You are exceeding the limit by %s by putting fatura with amount %s.", limit.subtract(sumBefore).add(amount), amount));
    }
}

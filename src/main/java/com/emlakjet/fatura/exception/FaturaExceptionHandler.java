package com.emlakjet.fatura.exception;

import com.emlakjet.fatura.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FaturaExceptionHandler {

    @ExceptionHandler(SumOfPSFaturasExceededLimit.class)
    public ResponseEntity<?> faturaSumExceededLimit(SumOfPSFaturasExceededLimit except) {
        return new ResponseEntity<>(new ErrorResponse(except.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}

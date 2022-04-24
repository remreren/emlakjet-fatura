package com.emlakjet.fatura.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
public class ErrorResponse<T> {
    private String message;
    private T body;
}

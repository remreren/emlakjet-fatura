package com.emlakjet.fatura.controller;

import com.emlakjet.fatura.dto.request.RequestNewFatura;
import com.emlakjet.fatura.dto.response.SuccessResponse;
import com.emlakjet.fatura.model.Fatura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FaturaController {

    @PutMapping("/")
    ResponseEntity<SuccessResponse<Fatura>> addNewFatura(@RequestBody RequestNewFatura request);
}

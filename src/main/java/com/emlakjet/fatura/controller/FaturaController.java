package com.emlakjet.fatura.controller;

import com.emlakjet.fatura.dto.request.RequestNewFatura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FaturaController {

    @PutMapping("/")
    ResponseEntity<?> addNewFatura(@RequestBody RequestNewFatura request);
}

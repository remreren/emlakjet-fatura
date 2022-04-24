package com.emlakjet.fatura.controller;

import com.emlakjet.fatura.dto.request.RequestNewFatura;
import com.emlakjet.fatura.dto.response.SuccessResponse;
import com.emlakjet.fatura.model.Fatura;
import com.emlakjet.fatura.service.FaturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fatura")
public class FaturaControllerImpl implements FaturaController {

    private final FaturaService faturaService;

    public FaturaControllerImpl(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @Override
    public ResponseEntity<SuccessResponse<Fatura>> addNewFatura(RequestNewFatura request) {
        log.debug("FCI-addNewFatura invoked.");
        Fatura fatura = faturaService.addNewFatura(request);
        return ResponseEntity.ok(new SuccessResponse<>(fatura));
    }
}

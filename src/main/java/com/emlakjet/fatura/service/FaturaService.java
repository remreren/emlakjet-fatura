package com.emlakjet.fatura.service;

import com.emlakjet.fatura.dto.request.RequestNewFatura;
import com.emlakjet.fatura.exception.SumOfPSFaturasExceededLimit;
import com.emlakjet.fatura.model.Fatura;
import com.emlakjet.fatura.repo.FaturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;

    @Value("${emlakjet.creditLimit}")
    private BigDecimal limit;

    /**
     * Gets the new fatura creation request and converts it into fatura entity object.
     * If sum of previous fatura's and current fatura's of the Purchasing Specialist
     * is greater than the given {@link #limit} in config file, then returns an error.
     * Otherwise, saves the new fatura to the database.
     *
     * @param faturaRequest {@link RequestNewFatura} Request to create a new fatura.
     * @return {@link Fatura} Data Access Object saved into database.
     */
    public Fatura addNewFatura(RequestNewFatura faturaRequest) {
        log.debug("FS-addNewFatura invoked.");
        Fatura fatura = convertRequestNewFaturaToFatura(faturaRequest);
        BigDecimal sumBefore = faturaRepository
                .getSumOfPSFaturas(fatura.getNameOfPS(), fatura.getSurnameOfPS(), fatura.getEmailOfPS())
                .orElse(BigDecimal.ZERO);
        if (sumBefore.add(fatura.getAmount()).compareTo(limit) > 0)
            throw new SumOfPSFaturasExceededLimit(sumBefore, fatura.getAmount(), limit);
        return faturaRepository.save(fatura);
    }

    // Converters
    private Fatura convertRequestNewFaturaToFatura(RequestNewFatura request) {
        return new Fatura(null, request.getFirstName(), request.getLastName(), request.getEmail(), request.getAmount(), request.getProductName(), null);
    }
}

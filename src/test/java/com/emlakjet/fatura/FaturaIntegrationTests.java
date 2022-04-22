package com.emlakjet.fatura;

import com.emlakjet.fatura.dto.request.RequestNewFatura;
import com.emlakjet.fatura.exception.SumOfPSFaturasExceededLimit;
import com.emlakjet.fatura.model.Fatura;
import com.emlakjet.fatura.repo.FaturaRepository;
import com.emlakjet.fatura.service.FaturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static com.emlakjet.fatura.util.FaturaUtility.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class FaturaIntegrationTests {

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private FaturaService faturaService;

    @Test
    public void createNewFatura_notExceedLimit() {
        Fatura fatura = faturaService.addNewFatura(requestFaturaEmre);

        Fatura faturaExpected = new Fatura(fatura.getId(), requestFaturaEmre.getFirstName(),
                requestFaturaEmre.getLastName(), requestFaturaEmre.getEmail(),
                requestFaturaEmre.getAmount(), requestFaturaEmre.getProductName(),
                String.format("TR%04d", fatura.getId()));

        assertEquals(faturaExpected.toString(), fatura.toString());
    }

    @Test
    public void createNewFatura_exceedLimitSingle() {
        RequestNewFatura faturaRequest = requestFaturaEmre.toBuilder().email("asdfg@gmail.com").amount(new BigDecimal(300)).build();
        assertThrowsExactly(SumOfPSFaturasExceededLimit.class, () -> faturaService.addNewFatura(faturaRequest));
    }
}

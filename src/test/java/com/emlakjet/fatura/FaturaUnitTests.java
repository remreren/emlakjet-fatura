package com.emlakjet.fatura;

import com.emlakjet.fatura.model.Fatura;
import com.emlakjet.fatura.repo.FaturaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static com.emlakjet.fatura.util.FaturaUtility.*;

@SpringBootTest
@ActiveProfiles("test")
public class FaturaUnitTests {

    @Autowired
    private FaturaRepository faturaRepository;

    @Test
    public void insertFatura_modelTest() {
        Fatura ret = faturaRepository.save(faturaEmre);
        Fatura fatura = faturaEmre.toBuilder()
                .id(ret.getId())
                .billNo(String.format("TR%04d", ret.getId()))
                .build();

        assertEquals(fatura, ret);
    }

    @Test
    public void insertFatura_getTotalFatura() {
        Fatura fatura = faturaEmre.toBuilder().nameOfPS("abcde").build();
        Fatura ret1 = faturaRepository.save(fatura.toBuilder().amount(new BigDecimal(150)).build());
        Fatura ret2 = faturaRepository.save(fatura.toBuilder().amount(new BigDecimal(140)).build());

        BigDecimal sum = faturaRepository
                .getSumOfPSFaturas(fatura.getNameOfPS(), fatura.getSurnameOfPS(), fatura.getEmailOfPS())
                .orElse(BigDecimal.ZERO);

        assertEquals(0, ret1.getAmount().add(ret2.getAmount()).compareTo(sum));
    }
}

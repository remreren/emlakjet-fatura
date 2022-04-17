package com.emlakjet.fatura.repo;

import com.emlakjet.fatura.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    @Query("select sum(amount) from Fatura where nameOfPS=:nameOfPS and surnameOfPS=:surnameOfPS and emailOfPS=:emailOfPS")
    Optional<BigDecimal> getSumOfPSFaturas(String nameOfPS, String surnameOfPS, String emailOfPS);
}

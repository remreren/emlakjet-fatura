package com.emlakjet.fatura.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

// PS = Purchasing Specialist
@Data
@Builder(toBuilder = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfPS;
    private String surnameOfPS;
    private String emailOfPS;
    private BigDecimal amount;
    private String productName;

    @Transient
    private String billNo;

    @PostLoad
    @PostPersist
    public void calcBillNo() {
        billNo = String.format("TR%04d", id);
    }
}

package com.emlakjet.fatura.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

// PS = Purchasing Specialist
@Getter
@Setter
@ToString
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


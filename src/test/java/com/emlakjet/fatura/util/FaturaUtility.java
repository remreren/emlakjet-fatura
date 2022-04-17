package com.emlakjet.fatura.util;

import com.emlakjet.fatura.model.Fatura;

import java.math.BigDecimal;

public class FaturaUtility {
    public static final Fatura faturaEmre = new Fatura(null, "Emre", "Eren", "eeren881@gmail.com", BigDecimal.TEN, "Product1", null);
    public static final Fatura faturaWho = new Fatura(null, "Who", "Isit", "who@isit.com", BigDecimal.TEN, "Product3", null);
}

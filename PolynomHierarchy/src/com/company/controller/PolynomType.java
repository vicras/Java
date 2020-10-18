package com.company.controller;

import com.company.model.polynomial.factory.ComplexPolynomGenerator;
import com.company.model.polynomial.factory.RationalPolynomGenerator;

public enum PolynomType {
    RATIO(RationalPolynomGenerator.class.getName()),
    COMPLEX(ComplexPolynomGenerator.class.getName());

    private String type;
    PolynomType(String name) {
        type = name;
    }

    public String getType() {
        return type;
    }
}

package com.bank.scheduler.model.enums;

import lombok.Getter;

@Getter
public enum Bank {
    SANTANDER("Santander"),
    BRADESCO("Bradesco"),
    BANCO_DO_BRASIL("Banco do Brasil"),
    ITAU("Itau"),
    NU_BANK("Nu Bank"),
    C6("C6 Bank"),
    MERCADO_PAGO("Mercado Pago");
    private String name;

    Bank(String name) {
        this.name = name;
    }
}

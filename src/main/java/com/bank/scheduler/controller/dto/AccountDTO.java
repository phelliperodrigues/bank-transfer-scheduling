package com.bank.scheduler.controller.dto;

import com.bank.scheduler.model.enums.Bank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;
    private Bank bank;
    private int agency;
    private long number;
    private int digit;
    private BigDecimal balance;
}

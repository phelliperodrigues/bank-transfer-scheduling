package com.bank.scheduler.controller.dto;

import com.bank.scheduler.model.enums.Bank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;

    @NotNull(message = "Bank is required")
    private Bank bank;

    @NotNull(message = "Agency is required")
    @Min(1)
    private Integer agency;

    @NotNull(message = "Number is required")
    @Min(10000)
    private Long number;

    @Min(0)
    @NotNull(message = "Digit is required")
    private Integer digit;

    private BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        this.balance = balance == null ? BigDecimal.ZERO : balance;
    }
}

package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class LoanDto {
    private BigDecimal amount;
    private double interestRate;
    @NotBlank
    private String description;
    @DecimalMin("0.01")
    private BigDecimal outstandingBalance;
    @NotBlank
    private String rateFrequency;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    private boolean isPaid;
    @NotBlank
    private String agreementDocumentPath;
    private int borrowerId;
    private int lenderId;
}

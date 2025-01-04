package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LoanDto( BigDecimal amount,
                      double interestRate,
                      @NotBlank String description,
                      @DecimalMin("0.01") BigDecimal outstandingBalance,
                      @NotBlank String rateFrequency,
                      @NotNull LocalDate startDate,
                      @NotNull LocalDate endDate,
                      boolean isPaid,
                      @NotBlank String agreementDocumentPath,
                      int borrowerId,
                      int lenderId) {
}

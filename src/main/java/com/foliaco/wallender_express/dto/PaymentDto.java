package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(@DecimalMin("0.01") BigDecimal amountPaid,
                         @NotNull LocalDate paymentDate,
                         int loanId) {
}

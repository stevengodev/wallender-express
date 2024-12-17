package com.foliaco.wallender_express.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(BigDecimal amountPaid,
                         LocalDate paymentDate,
                         int loanId) {
}

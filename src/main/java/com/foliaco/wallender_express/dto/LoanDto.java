package com.foliaco.wallender_express.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LoanDto(BigDecimal amount,
                      double interestRate,
                      String description,
                      BigDecimal outstandingBalance,
                      String rateFrequency,
                      LocalDate startDate,
                      LocalDate endDate,
                      boolean isPaid,
                      String agreementDocumentPath,
                      int borrowerId,
                      int lenderId) {
}

package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.DecimalMin;
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
public class PaymentDto {

    @DecimalMin("0.01")
    private BigDecimal amountPaid;
    @NotNull
    private LocalDate paymentDate;
    private int loanId;

}

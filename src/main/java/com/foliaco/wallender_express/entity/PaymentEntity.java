package com.foliaco.wallender_express.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Getter
@Setter
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "monto_abonado", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "fecha_de_pago", nullable = false)
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "id", nullable = false)
    private LoanEntity loanEntity;

}

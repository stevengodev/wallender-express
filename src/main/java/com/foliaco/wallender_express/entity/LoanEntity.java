package com.foliaco.wallender_express.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Setter
@Getter
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "monto", nullable = false)
    private BigDecimal amount;

    @Column(name = "tasa_interes", nullable = false)
    private double interestRate;

    @Column(name = "saldo_pendiente", nullable = false)
    private BigDecimal outstandingBalance;

    @Column(name = "tasa_frecuencia", nullable = false)
    private String rateFrequency;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate startDate;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate endDate;

    @Column(name = "pagado", nullable = false)
    private boolean isPaid;

    @Column(name = "ruta_documento_acuerdo", nullable = false)
    private String agreementDocumentPath;

    @ManyToOne
    @JoinColumn(name = "prestatario_id", referencedColumnName = "id", nullable = false)
    private UserEntity borrowerId;

    @ManyToOne
    @JoinColumn(name = "prestamista_id", referencedColumnName = "id", nullable = false)
    private UserEntity lenderId;

}

package com.foliaco.wallender_express.service;


import com.foliaco.wallender_express.dto.PaymentDto;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {

    /**
     * Crea un nuevo pago
     *
     * @param paymentDto
     * @return Pago
     */
    PaymentDto createPayment(PaymentDto paymentDto);

    /**
     * Actualiza un pago existente
     *
     * @param id
     * @param paymentDto
     * @return Pago actualizado
     */
    Optional<PaymentDto> updatePayment(Long id, PaymentDto paymentDto);

    /**
     * Elimina un pago
     *
     * @param id
     */
    void deletePayment(Long id);

    /**
     * Obtiene todos los pagos
     *
     * @return Lista de pagos
     */
    List<PaymentDto> getPayments();

    /**
     * Obtiene un pago por id
     *
     * @param id
     * @return Pago
     */
    Optional<PaymentDto> getPaymentById(Long id);

    /**
     * Obtiene los pagos por numero de tarjeta de credito del prestamista
     *
     * @param borrowerIdCard
     * @return Lista de pagos
     */
    List<PaymentDto> getPaymentsByBorrowerIdCard(String borrowerIdCard);

}

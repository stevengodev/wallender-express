package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.LoanDto;

import java.util.List;
import java.util.Optional;

public interface ILoanService {

    /**
     * Devuelve un prestamo por su id
     *
     * @param id
     * @return Prestamo
     */
    Optional<LoanDto> getLoanById(Integer id);

    /**
     * Crea un nuevo préstamo
     *
     * @param loanDto
     * @return Prestamo
     */
    LoanDto createLoan(LoanDto loanDto);

    /**
     * Actualiza un préstamo por su id
     *
     * @param id
     * @param loanDto
     * @return Prestamos actualizado
     */
    Optional<LoanDto> updateLoan(Integer id, LoanDto loanDto);

    /**
     * Elimina un préstamo por su id
     *
     * @param id
     */
    void deleteLoanById(Integer id);

    /**
     * Devuelve todos los préstamos activos, aquellos donde el saldo pendiente es mayor que 0.
     *
     * @return Listado completo de préstamos activos.
    */
    List<LoanDto> getActiveLoans();

    /**
     * Devuelve todos los préstamos pagados de un cliente.
     *
     * @param borrowerIdCard cedula del cliente.
     * @return Historial completo de préstamos del cliente.
     */
    List<LoanDto> getExpiredLoansByBorrowerIdCard(String borrowerIdCard);

    /**
     * Devuelve todos los préstamos activos asociados a un cliente.
     *
     * @param borrowerIdCard cedula del cliente.
     * @return Listado completo de préstamos activos del cliente.
    */
    List<LoanDto> getActiveLoansByBorrowerIdCard(String borrowerIdCard);


}

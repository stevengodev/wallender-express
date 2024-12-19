package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.LoanDto;

import java.util.Optional;

public interface ILoanService {

    Optional<LoanDto> getLoanById(Integer id);

    LoanDto createLoan(LoanDto loanDto);

    Optional<LoanDto> updateLoan(Integer id, LoanDto loanDto);

    void deleteLoanById(Integer id);
}

package com.foliaco.wallender_express.service.impl;

import com.foliaco.wallender_express.dto.LoanDto;
import com.foliaco.wallender_express.entity.LoanEntity;
import com.foliaco.wallender_express.exception.NotFoundException;
import com.foliaco.wallender_express.mapper.ILoanMapper;
import com.foliaco.wallender_express.repository.ILoanRepository;
import com.foliaco.wallender_express.service.ILoanService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Log4j2
public class LoanServiceImpl implements ILoanService {

    private ILoanRepository loanRepository;
    
    private ILoanMapper loanMapper;

    @Transactional(readOnly = true)
    @Override
    public Optional<LoanDto> getLoanById(Integer id) {
        log.info("getLoanById: {}", id);
        return loanRepository.findById(id)
                .map(loanMapper::toLoandDto);
    }

    @Transactional
    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        log.info("createLoan: {}", loanDto);
        LoanEntity loanEntity = loanMapper.toLoanEntity(loanDto);
        loanRepository.save(loanEntity);
        return loanMapper.toLoandDto(loanEntity);
    }

    @Transactional
    @Override
    public LoanDto updateLoan(Integer id, LoanDto loanDto) {
        log.info("updateLoan: {}", loanDto);
        LoanEntity loanEntity = loanRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Loan not found")
        );

        loanEntity.setAmount(loanDto.getAmount());
        loanEntity.setInterestRate(loanDto.getInterestRate());
        loanEntity.setDescription(loanDto.getDescription());
        loanEntity.setOutstandingBalance(loanDto.getOutstandingBalance());
        loanEntity.setRateFrequency(loanDto.getRateFrequency());
        loanEntity.setStartDate(loanDto.getStartDate());
        loanEntity.setEndDate(loanDto.getEndDate());
        loanEntity.setPaid(loanDto.isPaid());
        loanEntity.setAgreementDocumentPath(loanDto.getAgreementDocumentPath());
        loanEntity.setBorrowerId(loanDto.getBorrowerId());
        loanEntity.setLenderId(loanDto.getLenderId());

        return loanMapper.toLoandDto(loanRepository.save(loanEntity));
    }

    @Transactional
    @Override
    public void deleteLoanById(Integer id) {
        log.info("deleteLoanById: {}", id);

        LoanEntity loanEntity = loanRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Loan not found")
        );

        loanRepository.deleteById(loanEntity.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<LoanDto> getActiveLoans() {
        log.info("getActiveLoans");
        return loanRepository.getActiveLoans().stream()
                .map( loanMapper::toLoandDto )
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<LoanDto> getExpiredLoansByBorrowerIdCard(String borrowerIdCard) {
        log.info("getExpiredLoansByBorrowerIdCard: {}", borrowerIdCard);
        return loanRepository.getExpiredLoansByBorrowerIdCard(borrowerIdCard).stream()
                .map( loanMapper::toLoandDto )
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<LoanDto> getActiveLoansByBorrowerIdCard(String borrowerIdCard) {
        log.info("getActiveLoansByBorrowerIdCard: {}", borrowerIdCard);
        return loanRepository.getActiveLoansByBorrowerIdCard(borrowerIdCard).stream()
                .map( loanMapper::toLoandDto )
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<LoanDto> getActiveLoansByLenderIdCard(String lenderIdCard) {
        log.info("getActiveLoansByLenderIdCard: {}", lenderIdCard);
        return loanRepository.getActiveLoansByLenderIdCard(lenderIdCard).stream()
                .map( loanMapper::toLoandDto )
                .toList();
    }
}

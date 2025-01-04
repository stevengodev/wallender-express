package com.foliaco.wallender_express.repository;

import com.foliaco.wallender_express.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Integer> {

    @Query("SELECT l FROM LoanEntity l WHERE l.outstandingBalance > 0")
    List<LoanEntity> getActiveLoans();

    @Query("SELECT l FROM LoanEntity l WHERE l.outstandingBalance = 0 AND l.borrower.idCard = :id_card")
    List<LoanEntity> getExpiredLoansByBorrowerIdCard(@Param("id_card") String idCard);

    @Query("SELECT l FROM LoanEntity l WHERE l.outstandingBalance > 0 AND l.borrower.idCard = :id_card")
    List<LoanEntity> getActiveLoansByBorrowerIdCard(@Param("id_card") String idCard);

}

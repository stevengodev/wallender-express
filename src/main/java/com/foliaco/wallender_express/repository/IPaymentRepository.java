package com.foliaco.wallender_express.repository;

import com.foliaco.wallender_express.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Integer> {

    @Query("SELECT p FROM PaymentEntity p INNER JOIN LoanEntity l WHERE p.loanEntity.id = l.id AND l.borrower.id = :borrow_id_card")
    List<PaymentEntity> getPaymentsByBorrowerIdCard(@Param("borrow_id_card") String borrowIdCard);

}

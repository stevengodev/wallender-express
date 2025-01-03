package com.foliaco.wallender_express.repository;

import com.foliaco.wallender_express.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Integer> {
}

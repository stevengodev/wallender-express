package com.foliaco.wallender_express.mapper;

import com.foliaco.wallender_express.dto.LoanDto;
import com.foliaco.wallender_express.entity.LoanEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ILoanMapper {

    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "interestRate", source = "interestRate")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "outstandingBalance", source = "outstandingBalance")
    @Mapping(target = "rateFrequency", source = "rateFrequency")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "paid", source = "paid")
    @Mapping(target = "agreementDocumentPath", source = "agreementDocumentPath")
    @Mapping(target = "borrowerId", source = "borrower.id")
    @Mapping(target = "lenderId", source = "lender.id")
    LoanDto toLoandDto(LoanEntity entity);


    @InheritInverseConfiguration
    @Mapping(target = "borrower", ignore = true)
    @Mapping(target = "lender", ignore = true)
    LoanEntity toLoanEntity(LoanDto dto);

}

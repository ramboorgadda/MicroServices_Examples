package com.eazybites.loans.mapper;

import com.eazybites.loans.dto.LoansDto;
import com.eazybites.loans.entity.Loans;

import java.util.Optional;

public class LoanMapper {

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto){
          loansDto.setLoanType(loans.getLoanType());
          loansDto.setLoanNumber(loans.getLoanNumber());
          loansDto.setMobileNumber(loans.getMobileNumber());
          loansDto.setTotalLoan(loans.getTotalLoan());
          loansDto.setAmountPaid(loans.getAmountPaid());
          loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto,Loans loans){
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }
}

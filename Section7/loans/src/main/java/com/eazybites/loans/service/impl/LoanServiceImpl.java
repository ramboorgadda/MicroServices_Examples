package com.eazybites.loans.service.impl;

import com.eazybites.loans.constants.LoanConstants;
import com.eazybites.loans.dto.LoansDto;
import com.eazybites.loans.entity.Loans;
import com.eazybites.loans.exception.LoanAlreadyExistsException;
import com.eazybites.loans.exception.ResourceNotFoundException;
import com.eazybites.loans.mapper.LoanMapper;
import com.eazybites.loans.repository.LoansRepository;
import com.eazybites.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements ILoansService {

    private LoansRepository loansRepository;
    @Override
    public void createLoan(String mobileNumber) {
       Optional<Loans> loans=loansRepository.findByMobileNumber(mobileNumber);
       if(loans.isPresent()){
           throw new LoanAlreadyExistsException("Loan already exists with this mobile number "+mobileNumber);
       }
       loansRepository.save(createNewLoan(mobileNumber));
    }
    private Loans createNewLoan(String mobileNumber){
        Loans newloan = new Loans();
        Long randomNumber = 100000000000L+new Random().nextInt(10000);
        newloan.setLoanNumber(randomNumber.toString());
        newloan.setLoanType(LoanConstants.HOME_LOAN);
        newloan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newloan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        newloan.setAmountPaid(0);
        newloan.setMobileNumber(mobileNumber);
//        newloan.setCreatedAt(LocalDateTime.now());
//        newloan.setCreatedBy("LOANS_MS");
        return newloan;
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans =loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
        );
        return LoanMapper.mapToLoansDto(loans,new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        String loanNumber=loansDto.getLoanNumber();
        System.out.println("loan number is "+loanNumber);
      Loans loans =loansRepository.findByLoanNumber(loanNumber).orElseThrow(
              () -> new ResourceNotFoundException("Loan","LoanNumber", loansDto.getLoanNumber())
      );
      LoanMapper.mapToLoans(loansDto,loans);
      loansRepository.save(loans);
      return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
      Loans loans=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
              () -> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
      );
        loansRepository.deleteById(loans.getLoanId());
        //loansRepository.save(loans);
        return true;
    }
}

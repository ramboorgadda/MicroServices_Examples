package com.eazybites.loans.service;

import com.eazybites.loans.dto.LoansDto;

public interface ILoansService {
  void createLoan(String mobileNumber);

  LoansDto fetchLoan(String mobileNumber);

  boolean updateLoan(LoansDto loansDto);
  boolean deleteLoan(String mobileNummber);
}

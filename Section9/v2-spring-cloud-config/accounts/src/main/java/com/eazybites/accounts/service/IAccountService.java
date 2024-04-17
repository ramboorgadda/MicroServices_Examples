package com.eazybites.accounts.service;

import com.eazybites.accounts.dto.CustomerDto;
import com.eazybites.accounts.entity.Customer;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}

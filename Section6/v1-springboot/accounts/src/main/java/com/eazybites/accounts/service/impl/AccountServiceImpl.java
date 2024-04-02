package com.eazybites.accounts.service.impl;

import com.eazybites.accounts.constants.AccountsConstants;
import com.eazybites.accounts.dto.AccountsDto;
import com.eazybites.accounts.dto.CustomerDto;
import com.eazybites.accounts.entity.Accounts;
import com.eazybites.accounts.entity.Customer;
import com.eazybites.accounts.exception.CustomerAlreadyExistsException;
import com.eazybites.accounts.exception.ResourceNotFoundException;
import com.eazybites.accounts.mapper.AccountsMapper;
import com.eazybites.accounts.mapper.CustomerMapper;
import com.eazybites.accounts.repository.AccountsRepository;
import com.eazybites.accounts.repository.CustomerRepository;
import com.eazybites.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Already Registered with given mobileNumber "+customerDto.getMobileNumber());
        }
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }
    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L+ new Random().nextInt(900000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
            () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );

        Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString())
        );
        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto=customerDto.getAccountsDto();
        if(accountsDto!=null){
            System.out.println("Inside updateAccount ServiceImpl");
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                       ()-> new ResourceNotFoundException("Account","AccountNumber",accountsDto.getAccountNumber().toString())
               );
            AccountsMapper.mapToAccounts(accountsDto,accounts);
            accounts=accountsRepository.save(accounts);
            Long customerId=accounts.getCustomerId();
            Customer customer= customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer","CustomerID",customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
       return isUpdated;

    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","MobileNumber",mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }


}

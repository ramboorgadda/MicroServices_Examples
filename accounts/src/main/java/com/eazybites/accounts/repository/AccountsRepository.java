package com.eazybites.accounts.repository;

import com.eazybites.accounts.entity.Accounts;
import com.eazybites.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByCustomerId(long customerId);
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}

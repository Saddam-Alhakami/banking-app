package com.banking.banking_app.repository;

import com.banking.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

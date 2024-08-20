package com.banking.banking_app.service.impl;

import com.banking.banking_app.dto.AccountDTO;
import com.banking.banking_app.entity.Account;
import com.banking.banking_app.mapper.AccountMapper;
import com.banking.banking_app.repository.AccountRepository;
import com.banking.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceIMPL implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceIMPL(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(saveAccount);

    }

    @Override
    public AccountDTO getAccountById(long id) {
        Account account = accountRepository.findById(id).orElse(null);
        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(updatedAccount);
    }

    @Override
    public AccountDTO withdrawal(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insuffient amount");
        }
        account.setBalance(account.getBalance() - amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(updatedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account ->
                        AccountMapper.mapToAccountDTO(account)).
                collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(long id) {
        Account account=accountRepository.findById(id).orElse(null);
        accountRepository.delete(account);
    }
}
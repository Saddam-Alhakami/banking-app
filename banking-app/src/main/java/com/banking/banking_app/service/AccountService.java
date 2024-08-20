package com.banking.banking_app.service;

import com.banking.banking_app.dto.AccountDTO;

import java.util.List;


public interface AccountService {
    AccountDTO createAccount(AccountDTO account);
    AccountDTO getAccountById(long id);
    AccountDTO deposit(long  id, double amount);
    AccountDTO withdrawal(long  id, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(long id);



}

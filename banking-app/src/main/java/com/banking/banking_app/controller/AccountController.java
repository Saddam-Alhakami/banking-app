package com.banking.banking_app.controller;

import com.banking.banking_app.dto.AccountDTO;
import com.banking.banking_app.entity.Account;
import com.banking.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
         this.accountService = accountService;
     }

     @PostMapping
     public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
     }


     @GetMapping("/{id}")
     public ResponseEntity<AccountDTO> getAccountById(@PathVariable long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
     }

     @PutMapping("/{id}/{amount}/deposit")
     public  ResponseEntity<AccountDTO> deposit(@PathVariable long id, @PathVariable double amount) {
        return new ResponseEntity<>(accountService.deposit(id,amount), HttpStatus.OK);
     }

    @PutMapping("/{id}/{amount}/withdrawal")
     public ResponseEntity<AccountDTO> withdrawal(@PathVariable long id, @PathVariable double amount) {
         return new ResponseEntity<>(accountService.withdrawal(id,amount), HttpStatus.OK);
     }


     public List<AccountDTO> getAllAccounts() {

        return accountService.getAllAccounts();
     }

     @DeleteMapping("/{id}")
     public void deleteAccount(@PathVariable  long id){
        accountService.deleteAccount(id);
     }

}

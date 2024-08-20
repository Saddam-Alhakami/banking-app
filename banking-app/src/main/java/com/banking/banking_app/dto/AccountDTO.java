package com.banking.banking_app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.PrivateKey;
@Data
@AllArgsConstructor
public class AccountDTO {
    private long id;
    private String accountHolderName;
    private double balance;
}


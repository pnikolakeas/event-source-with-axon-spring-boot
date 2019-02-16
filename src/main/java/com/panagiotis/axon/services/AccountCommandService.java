package com.panagiotis.axon.services;

import com.panagiotis.axon.dtos.AccountCreatedDTO;
import com.panagiotis.axon.dtos.MoneyCreditDTO;
import com.panagiotis.axon.dtos.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    CompletableFuture<String> createAccount(AccountCreatedDTO accountCreatedDTO);

    CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

    CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);

}

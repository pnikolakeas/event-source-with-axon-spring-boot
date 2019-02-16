package com.panagiotis.axon.services;

import com.panagiotis.axon.commands.CreateAccountCommand;
import com.panagiotis.axon.commands.CreditMoneyCommand;
import com.panagiotis.axon.commands.DebitMoneyCommand;
import com.panagiotis.axon.dtos.AccountCreatedDTO;
import com.panagiotis.axon.dtos.MoneyCreditDTO;
import com.panagiotis.axon.dtos.MoneyDebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    // Basically, this is a convenience interface provided by Axon. In other words, you can use this interface to dispatch commands.
    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreatedDTO accountCreatedDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreatedDTO.getStartingBalance(), accountCreatedDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}

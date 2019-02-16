package com.panagiotis.axon.aggregates;

import com.panagiotis.axon.commands.CreateAccountCommand;
import com.panagiotis.axon.commands.CreditMoneyCommand;
import com.panagiotis.axon.commands.DebitMoneyCommand;
import com.panagiotis.axon.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static com.panagiotis.axon.aggregates.Status.*;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String id;

    private double accountBalance;

    private String currency;

    private String status;

    public AccountAggregate() { /* AXON framework needs it */ }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.getId(), createAccountCommand.getAccountBalance(), createAccountCommand.getCurrency()));
    }

    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand) {
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.getId(), creditMoneyCommand.getCreditAmount(), creditMoneyCommand.getCurrency()));
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand) {
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.getId(), debitMoneyCommand.getDebitAmount(), debitMoneyCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent) {
        this.id = accountCreatedEvent.getId();
        this.accountBalance = accountCreatedEvent.getAccountBalance();
        this.currency = accountCreatedEvent.getCurrency();
        this.status = String.valueOf(Status.CREATED);
        AggregateLifecycle.apply(new AccountActivatedEvent(this.id, ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent) {
        this.status = String.valueOf(accountActivatedEvent.getStatus());
    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent) {
        this.status = String.valueOf(accountHeldEvent.getStatus());
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent) {
        if(this.accountBalance < 0 && (this.accountBalance + moneyCreditedEvent.getCreditAmount()) >= 0) {
            AggregateLifecycle.apply(new AccountActivatedEvent(this.id, ACTIVATED));
        }
        this.accountBalance += moneyCreditedEvent.getCreditAmount();
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent) {
        if(this.accountBalance >=0 && (this.accountBalance - moneyDebitedEvent.getDebitAmount()) < 0) {
            AggregateLifecycle.apply(new AccountHeldEvent(this.id, HOLD));
        }
        this.accountBalance -= moneyDebitedEvent.getDebitAmount();
    }
}

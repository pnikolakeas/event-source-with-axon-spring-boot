package com.panagiotis.axon.events;

public class AccountCreatedEvent extends BaseEvent<String> {

    private final double accountBalance;

    private final String currency;

    public AccountCreatedEvent(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCurrency() {
        return currency;
    }
}

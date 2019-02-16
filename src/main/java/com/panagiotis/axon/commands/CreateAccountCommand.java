package com.panagiotis.axon.commands;

public class CreateAccountCommand extends BaseCommand<String> {

    private final double accountBalance;

    private final String currency;

    public CreateAccountCommand(String id, double accountBalance, String currency) {
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

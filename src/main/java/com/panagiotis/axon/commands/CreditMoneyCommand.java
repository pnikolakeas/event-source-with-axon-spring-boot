package com.panagiotis.axon.commands;

public class CreditMoneyCommand extends BaseCommand<String> {

    private final double creditAmount;

    private final String currency;

    public CreditMoneyCommand(String id, double creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public String getCurrency() {
        return currency;
    }
}

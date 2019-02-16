package com.panagiotis.axon.commands;

public class DebitMoneyCommand extends BaseCommand<String> {

    private final double debitAmount;

    private final String currency;

    public DebitMoneyCommand(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public String getCurrency() {
        return currency;
    }
}

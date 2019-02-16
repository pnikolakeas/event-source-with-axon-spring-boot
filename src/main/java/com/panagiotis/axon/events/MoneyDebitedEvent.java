package com.panagiotis.axon.events;

public class MoneyDebitedEvent extends BaseEvent<String> {

    private final double debitAmount;

    private final String currency;

    public MoneyDebitedEvent(String id, double debitAmount, String currency) {
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

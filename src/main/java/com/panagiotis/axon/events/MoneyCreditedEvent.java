package com.panagiotis.axon.events;

public class MoneyCreditedEvent extends BaseEvent<String> {

    private final double creditAmount;

    private final String currency;

    public MoneyCreditedEvent(String id, double creditAmount, String currency) {
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

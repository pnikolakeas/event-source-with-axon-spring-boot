package com.panagiotis.axon.events;

import com.panagiotis.axon.aggregates.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    private final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}

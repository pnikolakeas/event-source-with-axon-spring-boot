package com.panagiotis.axon.services;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.*;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    // EventStore provides a method to read events for a particular AggregateId.
    private final EventStore eventStore;

    public AccountQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map(s -> s.getPayload()).collect(toList());
    }
}

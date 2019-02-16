package com.panagiotis.axon.services;

import java.util.List;

public interface AccountQueryService {

    List<Object> listEventsForAccount(String accountNumber);

}

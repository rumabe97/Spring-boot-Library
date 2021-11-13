package com.xbidi.spring.content.lending.infrastructure.repository.port;


import com.xbidi.spring.content.lending.domain.Lending;

public interface FindLendingPort {
    Lending findById(String id) throws Exception;
}

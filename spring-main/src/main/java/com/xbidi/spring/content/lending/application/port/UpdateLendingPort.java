package com.xbidi.spring.content.lending.application.port;

import com.xbidi.spring.content.lending.domain.Lending;

public interface UpdateLendingPort {
    Lending update(String idLending, Lending lending) throws Exception;
}

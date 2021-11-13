package com.xbidi.spring.content.lending.infrastructure.repository.port;


import com.xbidi.spring.content.lending.domain.Lending;

public interface SaveLendigPort {
    Lending save(Lending lending);
}

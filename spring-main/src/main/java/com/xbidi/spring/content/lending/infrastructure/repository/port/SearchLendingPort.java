package com.xbidi.spring.content.lending.infrastructure.repository.port;


import com.xbidi.spring.content.lending.domain.Lending;
import org.springframework.data.domain.Page;

public interface SearchLendingPort {
  Page<Lending> search(Lending lending, int page, int size);
}

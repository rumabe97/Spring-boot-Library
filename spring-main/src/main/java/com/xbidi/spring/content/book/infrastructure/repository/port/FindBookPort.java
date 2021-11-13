package com.xbidi.spring.content.book.infrastructure.repository.port;

import com.xbidi.spring.content.book.domain.Book;

public interface FindBookPort {
    Book findById(String id) throws Exception;
}

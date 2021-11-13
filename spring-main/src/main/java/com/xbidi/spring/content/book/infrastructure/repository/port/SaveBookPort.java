package com.xbidi.spring.content.book.infrastructure.repository.port;

import com.xbidi.spring.content.book.domain.Book;

public interface SaveBookPort {
    Book save(Book book);
}

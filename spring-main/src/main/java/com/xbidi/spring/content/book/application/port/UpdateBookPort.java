package com.xbidi.spring.content.book.application.port;

import com.xbidi.spring.content.book.domain.Book;

public interface UpdateBookPort {
    Book update(String idBook, Book book) throws Exception;
}

package com.xbidi.spring.content.book.infrastructure.repository.port;

import com.xbidi.spring.content.book.domain.Book;
import org.springframework.data.domain.Page;

public interface SearchBookPort {
    Page<Book> search(Book book, int page, int size);
}

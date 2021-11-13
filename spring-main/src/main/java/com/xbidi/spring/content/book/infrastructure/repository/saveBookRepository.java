package com.xbidi.spring.content.book.infrastructure.repository;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.domain.BookJPA;
import com.xbidi.spring.content.book.infrastructure.repository.jpa.BookRepositoryJpa;
import com.xbidi.spring.content.book.infrastructure.repository.port.SaveBookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class saveBookRepository implements SaveBookPort {
    private BookRepositoryJpa bookRepositoryJpa;
    @Override
    public Book save(Book book) {
        BookJPA bookJPA = new BookJPA(book);
        BookJPA bookJPASaved = bookRepositoryJpa.save(bookJPA);

        return new Book(bookJPASaved);
    }
}

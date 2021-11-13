package com.xbidi.spring.content.book.infrastructure.repository;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.domain.BookJPA;
import com.xbidi.spring.content.book.infrastructure.repository.jpa.BookRepositoryJpa;
import com.xbidi.spring.content.book.infrastructure.repository.port.FindBookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindBookRepository implements FindBookPort {

    private BookRepositoryJpa bookRepositoryJpa;

    @Override
    public Book findById(String id) throws Exception {
        BookJPA bookJPA = bookRepositoryJpa.findById(id).orElseThrow(()-> new Exception("Book not found with id: " + id));
        return new Book(bookJPA);
    }
}

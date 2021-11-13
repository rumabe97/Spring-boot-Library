package com.xbidi.spring.content.book.application;

import com.xbidi.spring.content.book.application.port.UpdateBookPort;
import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.infrastructure.repository.port.FindBookPort;
import com.xbidi.spring.content.book.infrastructure.repository.port.SaveBookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateBookUserCase implements UpdateBookPort {

    private FindBookPort findBookPort;
    private SaveBookPort saveBookPort;

    @Override
    public Book update(String idBook, Book updatedValuesBook) throws Exception {
        Book currentBook = findBookPort.findById(idBook);
        currentBook.updateWith(updatedValuesBook);
        Book updatedBook = saveBookPort.save(currentBook);
        return updatedBook;
    }
}

package com.xbidi.spring.content.book.infrastructure.controller;

import com.xbidi.spring.content.book.application.port.UpdateBookPort;
import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.infrastructure.controller.dto.BookInputDTO;
import com.xbidi.spring.content.book.infrastructure.controller.dto.BookOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Book"})
public class UpdateBookController {
    private UpdateBookPort updateBookPort;

    @PutMapping("book/{id}")
    @Transactional(rollbackFor = Exception.class)
    public BookOutputDTO update(@PathVariable("id") String id, @RequestBody BookInputDTO bookInputDTO)
            throws Exception {
        Book bookValuesUpdated = bookInputDTO.toBook();
        Book bookUpdated = updateBookPort.update(id, bookValuesUpdated);
        return new BookOutputDTO(bookUpdated);
    }
}

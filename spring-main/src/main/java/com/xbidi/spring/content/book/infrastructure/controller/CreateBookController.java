package com.xbidi.spring.content.book.infrastructure.controller;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.infrastructure.controller.dto.BookInputDTO;
import com.xbidi.spring.content.book.infrastructure.controller.dto.SimpleBookOutputDTO;
import com.xbidi.spring.content.book.infrastructure.repository.port.SaveBookPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Book"})
public class CreateBookController {
    private SaveBookPort saveBookPort;

    @PostMapping("book/create")
    @Transactional(rollbackFor = Exception.class)
    public SimpleBookOutputDTO create(@RequestBody BookInputDTO bookInputDTO) throws Exception {
        Book book = bookInputDTO.toBook();
        Book createdBook = saveBookPort.save(book);
        return new SimpleBookOutputDTO(createdBook);
    }
}

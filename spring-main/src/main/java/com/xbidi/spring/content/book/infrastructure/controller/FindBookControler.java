package com.xbidi.spring.content.book.infrastructure.controller;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.infrastructure.controller.dto.BookOutputDTO;
import com.xbidi.spring.content.book.infrastructure.repository.port.FindBookPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Book"})
@RequestMapping("Book")
public class FindBookControler {
    private FindBookPort findBookPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public BookOutputDTO findById(@PathVariable("id") String id) throws Exception {
        Book book = findBookPort.findById(id);
        return new BookOutputDTO(book);
    }
}

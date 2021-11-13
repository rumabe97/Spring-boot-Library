package com.xbidi.spring.content.book.infrastructure.controller;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.infrastructure.controller.dto.BookOutputDTO;
import com.xbidi.spring.content.book.infrastructure.controller.dto.searchInputDTO;
import com.xbidi.spring.content.book.infrastructure.repository.port.SearchBookPort;
import com.xbidi.spring.shared.dto.PagedListDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Api(tags = {"Book"})
@RequestMapping("Book")
public class SearchBookController {

    private SearchBookPort searchBookPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<BookOutputDTO> search(
            searchInputDTO bookInputDTO,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "10") int size){
        Book book = bookInputDTO.toBook();
        Page<Book> bookPage = searchBookPort.search(book, page, size);
        List<BookOutputDTO> bookOutputDTOS = bookPage.stream().map(BookOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(bookOutputDTOS, bookPage.getTotalElements(), bookPage.getTotalPages());
    }
}

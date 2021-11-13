package com.xbidi.spring.content.author.infrastructure.controller;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorInputDTO;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorOutputDTO;
import com.xbidi.spring.content.author.infrastructure.repository.port.SearchAuthorPort;
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
@Api(tags = {"Author"})
@RequestMapping("author")
public class SearchAuthorController {
    private SearchAuthorPort searchBookPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<AuthorOutputDTO> search(
            AuthorInputDTO authorInputDTO,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "10") int size){
        Author author = authorInputDTO.toAuthor();
        Page<Author> authorPage = searchBookPort.search(author, page, size);
        List<AuthorOutputDTO> authorOutputDTOS = authorPage.stream().map(AuthorOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(authorOutputDTOS, authorPage.getTotalElements(), authorPage.getTotalPages());
    }
}

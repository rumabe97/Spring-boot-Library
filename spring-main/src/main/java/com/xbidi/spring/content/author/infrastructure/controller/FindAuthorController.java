package com.xbidi.spring.content.author.infrastructure.controller;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorOutputDTO;
import com.xbidi.spring.content.author.infrastructure.repository.port.FindAuthorPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Author"})
@RequestMapping("author")
public class FindAuthorController {
    private FindAuthorPort findAuthorPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public AuthorOutputDTO findById(@PathVariable("id") String id) throws Exception {
        Author author = findAuthorPort.findById(id);
        return new AuthorOutputDTO(author);
    }
}

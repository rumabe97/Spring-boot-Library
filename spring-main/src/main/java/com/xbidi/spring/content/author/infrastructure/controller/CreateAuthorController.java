package com.xbidi.spring.content.author.infrastructure.controller;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorInputDTO;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorOutputDTO;
import com.xbidi.spring.content.author.infrastructure.repository.port.SaveAuthorPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Author"})
public class CreateAuthorController {
    private SaveAuthorPort saveAuthorPort;

    @PostMapping("author/create")
    @Transactional(rollbackFor = Exception.class)
    public AuthorOutputDTO create(@RequestBody AuthorInputDTO authorInputDTO) throws Exception {
        Author author = authorInputDTO.toAuthor();
        Author createdAuthor = saveAuthorPort.save(author);
        return new AuthorOutputDTO(createdAuthor);
    }
}

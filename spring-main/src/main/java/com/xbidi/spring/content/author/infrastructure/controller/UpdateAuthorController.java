package com.xbidi.spring.content.author.infrastructure.controller;

import com.xbidi.spring.content.author.application.port.UpdatedAuthorPort;
import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorInputDTO;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Author"})
public class UpdateAuthorController {
    private UpdatedAuthorPort updateAuthorPort;

    @PutMapping("author/{id}")
    @Transactional(rollbackFor = Exception.class)
    public AuthorOutputDTO update(@PathVariable("id") String id, @RequestBody AuthorInputDTO authorInputDTO)
            throws Exception {
        Author authorValuesUpdated = authorInputDTO.toAuthor();
        Author authorUpdated = updateAuthorPort.update(id, authorValuesUpdated);
        return new AuthorOutputDTO(authorUpdated);
    }
}

package com.xbidi.spring.content.author.infrastructure.repository;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.domain.AuthorJPA;
import com.xbidi.spring.content.author.infrastructure.repository.jpa.AuthorRepositoryJPA;
import com.xbidi.spring.content.author.infrastructure.repository.port.SaveAuthorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveAuthorRepository implements SaveAuthorPort {
    private AuthorRepositoryJPA authorRepositoryJPA;

    @Override
    public Author save(Author author) {
        AuthorJPA authorJPA = new AuthorJPA(author);
        AuthorJPA authorSaved = authorRepositoryJPA.save(authorJPA);

        return new Author(authorSaved);
    }
}

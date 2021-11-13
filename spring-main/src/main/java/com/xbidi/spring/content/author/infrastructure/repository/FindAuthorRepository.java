package com.xbidi.spring.content.author.infrastructure.repository;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.domain.AuthorJPA;
import com.xbidi.spring.content.author.infrastructure.repository.jpa.AuthorRepositoryJPA;
import com.xbidi.spring.content.author.infrastructure.repository.port.FindAuthorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindAuthorRepository implements FindAuthorPort {
    private AuthorRepositoryJPA authorRepositoryJPA;
    @Override
    public Author findById(String id) throws Exception {
        AuthorJPA authorJPA = authorRepositoryJPA.findById(id).orElseThrow(()-> new Exception("Author not found with id: " + id));
        return new Author(authorJPA);
    }
}

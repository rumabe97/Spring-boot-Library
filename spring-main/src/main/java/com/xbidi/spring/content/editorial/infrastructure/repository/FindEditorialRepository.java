package com.xbidi.spring.content.editorial.infrastructure.repository;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import com.xbidi.spring.content.editorial.infrastructure.repository.jpa.EditorialRepositoryJpa;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.FindEditorialPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindEditorialRepository implements FindEditorialPort {
    private EditorialRepositoryJpa editorialRepositoryJpa;

    @Override
    public Editorial findById(String id) throws Exception {
        EditorialJPA editorialJPA = editorialRepositoryJpa.findById(id).orElseThrow(()-> new Exception("Editorial not found with id: " + id));
        return new Editorial(editorialJPA);
    }
}

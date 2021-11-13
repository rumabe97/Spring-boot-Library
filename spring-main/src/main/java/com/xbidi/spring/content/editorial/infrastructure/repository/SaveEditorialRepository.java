package com.xbidi.spring.content.editorial.infrastructure.repository;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import com.xbidi.spring.content.editorial.infrastructure.repository.jpa.EditorialRepositoryJpa;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.SaveEditorialPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveEditorialRepository implements SaveEditorialPort{
    private EditorialRepositoryJpa editorialRepositoryJpa;

    @Override
    public Editorial save(Editorial editorial) {
        EditorialJPA editorialJPA = new EditorialJPA(editorial);
        EditorialJPA editorialJPASaved = editorialRepositoryJpa.save(editorialJPA);

        return new Editorial(editorialJPASaved);
    }
}

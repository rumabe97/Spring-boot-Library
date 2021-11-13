package com.xbidi.spring.content.editorial.infrastructure.repository.jpa;

import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositoryJpa extends JpaRepository<EditorialJPA, String> {
}

package com.xbidi.spring.content.author.infrastructure.repository.jpa;

import com.xbidi.spring.content.author.domain.AuthorJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositoryJPA extends JpaRepository<AuthorJPA, String> {
}

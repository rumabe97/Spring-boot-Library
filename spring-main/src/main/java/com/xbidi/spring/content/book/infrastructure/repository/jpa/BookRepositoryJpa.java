package com.xbidi.spring.content.book.infrastructure.repository.jpa;

import com.xbidi.spring.content.book.domain.BookJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryJpa extends JpaRepository<BookJPA, String> {
}

package com.xbidi.spring.content.author.infrastructure.repository.port;

import com.xbidi.spring.content.author.domain.Author;
import org.springframework.data.domain.Page;

public interface SearchAuthorPort {
    Page<Author> search(Author author, int page, int size);
}

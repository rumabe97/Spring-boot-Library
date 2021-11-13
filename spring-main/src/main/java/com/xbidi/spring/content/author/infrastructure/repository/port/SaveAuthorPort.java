package com.xbidi.spring.content.author.infrastructure.repository.port;

import com.xbidi.spring.content.author.domain.Author;

public interface SaveAuthorPort {
    Author save(Author author);
}

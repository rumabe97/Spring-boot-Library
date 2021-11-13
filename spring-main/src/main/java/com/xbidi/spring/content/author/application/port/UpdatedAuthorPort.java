package com.xbidi.spring.content.author.application.port;

import com.xbidi.spring.content.author.domain.Author;

public interface UpdatedAuthorPort {
    Author update(String idAuthor, Author author) throws Exception;
}

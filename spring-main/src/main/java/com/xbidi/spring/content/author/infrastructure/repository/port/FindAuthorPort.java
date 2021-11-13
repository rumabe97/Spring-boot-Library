package com.xbidi.spring.content.author.infrastructure.repository.port;

import com.xbidi.spring.content.author.domain.Author;

public interface FindAuthorPort {
    Author findById(String id) throws Exception;
}

package com.xbidi.spring.content.editorial.infrastructure.repository.port;

import com.xbidi.spring.content.editorial.domain.Editorial;

public interface FindEditorialPort {
    Editorial findById(String id) throws Exception;
}

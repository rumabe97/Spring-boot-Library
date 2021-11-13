package com.xbidi.spring.content.editorial.infrastructure.repository.port;

import com.xbidi.spring.content.editorial.domain.Editorial;

public interface SaveEditorialPort {
    Editorial save(Editorial editorial);
}

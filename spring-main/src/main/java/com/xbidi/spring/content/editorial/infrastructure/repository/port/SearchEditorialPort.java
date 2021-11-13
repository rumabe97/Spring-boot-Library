package com.xbidi.spring.content.editorial.infrastructure.repository.port;

import com.xbidi.spring.content.editorial.domain.Editorial;
import org.springframework.data.domain.Page;

public interface SearchEditorialPort {
    Page<Editorial> search(Editorial editorial, int page, int size);
}

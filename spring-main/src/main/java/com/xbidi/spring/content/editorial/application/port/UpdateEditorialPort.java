package com.xbidi.spring.content.editorial.application.port;

import com.xbidi.spring.content.editorial.domain.Editorial;

public interface UpdateEditorialPort {
    Editorial update(String idEditorial, Editorial editorial) throws Exception;
}

package com.xbidi.spring.content.Location.infrastructure.repository.port;

import com.xbidi.spring.content.Location.domain.Location;

public interface FindLocationPort {
    Location findById(String id) throws Exception;
}

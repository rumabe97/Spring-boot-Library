package com.xbidi.spring.content.Location.infrastructure.repository.port;

import com.xbidi.spring.content.Location.domain.Location;
import org.springframework.data.domain.Page;

public interface SearchLocationPort {
    Page<Location> search(Location location, int page, int size);
}

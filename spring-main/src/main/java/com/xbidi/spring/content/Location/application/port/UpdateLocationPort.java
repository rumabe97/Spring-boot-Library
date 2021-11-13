package com.xbidi.spring.content.Location.application.port;

import com.xbidi.spring.content.Location.domain.Location;

public interface UpdateLocationPort {
    Location update(String idLocation, Location location) throws Exception;
}

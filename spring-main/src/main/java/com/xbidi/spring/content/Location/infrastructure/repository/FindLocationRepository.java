package com.xbidi.spring.content.Location.infrastructure.repository;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.domain.LocationJPA;
import com.xbidi.spring.content.Location.infrastructure.repository.jpa.LocationRepositoryjpa;
import com.xbidi.spring.content.Location.infrastructure.repository.port.FindLocationPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindLocationRepository implements FindLocationPort {
    private LocationRepositoryjpa locationRepositoryjpa;

    @Override
    public Location findById(String id) throws Exception {
        LocationJPA locationJPA = locationRepositoryjpa.findById(id).orElseThrow(()-> new Exception("Location not found with id: " + id));
        return new Location(locationJPA);
    }
}

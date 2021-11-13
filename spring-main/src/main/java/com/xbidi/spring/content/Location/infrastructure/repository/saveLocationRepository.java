package com.xbidi.spring.content.Location.infrastructure.repository;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.domain.LocationJPA;
import com.xbidi.spring.content.Location.infrastructure.repository.jpa.LocationRepositoryjpa;
import com.xbidi.spring.content.Location.infrastructure.repository.port.SaveLocationPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class saveLocationRepository implements SaveLocationPort {
    private LocationRepositoryjpa locationRepositoryjpa;

    @Override
    public Location save(Location location) {
        LocationJPA locationJPA = new LocationJPA(location);
        LocationJPA locationSaved = locationRepositoryjpa.save(locationJPA);

        return new Location(locationSaved);
    }
}

package com.xbidi.spring.content.Location.application;

import com.xbidi.spring.content.Location.application.port.UpdateLocationPort;
import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.infrastructure.repository.port.FindLocationPort;
import com.xbidi.spring.content.Location.infrastructure.repository.port.SaveLocationPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatedLocationUserCase implements UpdateLocationPort {
    private FindLocationPort findLocationPort;
    private SaveLocationPort saveLocationPort;

    @Override
    public Location update(String idLocation, Location updatedValuesLocation) throws Exception {
        Location currentLocation = findLocationPort.findById(idLocation);
        currentLocation.updateWith(updatedValuesLocation);
        Location updatedLocation = saveLocationPort.save(currentLocation);
        return updatedLocation;
    }
}

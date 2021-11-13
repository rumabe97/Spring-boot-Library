package com.xbidi.spring.content.Location.infrastructure.controller;

import com.xbidi.spring.content.Location.application.port.UpdateLocationPort;
import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationInputDTO;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Location"})
public class UpdateLocationController {
    private UpdateLocationPort updateLocationPort;

    @PutMapping("location/{id}")
    @Transactional(rollbackFor = Exception.class)
    public LocationOutputDTO update(@PathVariable("id") String id, @RequestBody LocationInputDTO locationInputDTO)
            throws Exception {
        Location locationValuesUpdated = locationInputDTO.toLocation();
        Location locationUpdated = updateLocationPort.update(id, locationValuesUpdated);
        return new LocationOutputDTO(locationUpdated);
    }
}

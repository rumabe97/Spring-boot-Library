package com.xbidi.spring.content.Location.infrastructure.controller;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationInputDTO;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationOutputDTO;
import com.xbidi.spring.content.Location.infrastructure.repository.port.SaveLocationPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Location"})
public class CreateLocationController {
    private SaveLocationPort saveLocationPort;

    @PostMapping("location/create")
    @Transactional(rollbackFor = Exception.class)
    public LocationOutputDTO create(@RequestBody LocationInputDTO locationInputDTO) throws Exception {
        Location location = locationInputDTO.toLocation();
        Location createdLocation = saveLocationPort.save(location);
        return new LocationOutputDTO(createdLocation);
    }
}

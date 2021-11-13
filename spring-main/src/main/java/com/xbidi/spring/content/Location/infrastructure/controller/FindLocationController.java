package com.xbidi.spring.content.Location.infrastructure.controller;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationOutputDTO;
import com.xbidi.spring.content.Location.infrastructure.repository.port.FindLocationPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Location"})
@RequestMapping("location")
public class FindLocationController {
    private FindLocationPort findLocationPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public LocationOutputDTO findById(@PathVariable("id") String id) throws Exception {
        Location location = findLocationPort.findById(id);
        return new LocationOutputDTO(location);
    }
}

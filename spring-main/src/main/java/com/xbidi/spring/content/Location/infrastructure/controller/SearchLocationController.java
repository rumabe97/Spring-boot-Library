package com.xbidi.spring.content.Location.infrastructure.controller;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationInputDTO;
import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationOutputDTO;
import com.xbidi.spring.content.Location.infrastructure.repository.port.SearchLocationPort;
import com.xbidi.spring.shared.dto.PagedListDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Api(tags = {"Location"})
@RequestMapping("location")
public class SearchLocationController {

    private SearchLocationPort searchLocationPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<LocationOutputDTO> search(
            LocationInputDTO locationInputDTO,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "10") int size){
        Location location = locationInputDTO.toLocation();
        Page<Location> locationPage = searchLocationPort.search(location, page, size);
        List<LocationOutputDTO> locationOutputDTOS = locationPage.stream().map(LocationOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(locationOutputDTOS, locationPage.getTotalElements(), locationPage.getTotalPages());
    }
}

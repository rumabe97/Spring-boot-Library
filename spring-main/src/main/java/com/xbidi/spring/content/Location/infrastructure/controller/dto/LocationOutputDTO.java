package com.xbidi.spring.content.Location.infrastructure.controller.dto;

import com.xbidi.spring.content.Location.domain.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationOutputDTO {
    private String id;
    private String city;
    private String building;
    private String shelving;
    private String floor;

    public LocationOutputDTO(Location location){
        this.id=location.getId();
        this.city=location.getCity();
        this.building=location.getBuilding();
        this.shelving=location.getShelving();
        this.floor=location.getFloor();
    }
}

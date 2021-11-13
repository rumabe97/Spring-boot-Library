package com.xbidi.spring.content.Location.infrastructure.controller.dto;

import com.xbidi.spring.content.Location.domain.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationInputDTO {
    private String city;
    private String building;
    private String shelving;
    private String floor;

    public Location toLocation(){
        Location location = new Location();

        location.setCity(this.city);
        location.setBuilding(this.building);
        location.setShelving(this.shelving);
        location.setFloor(this.floor);

        return location;
    }
}

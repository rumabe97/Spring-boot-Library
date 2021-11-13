package com.xbidi.spring.content.Location.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String id;
    private String city;
    private String building;
    private String shelving;
    private String floor;

    private LocationJPA locationJPA;

    public Location (LocationJPA locationJPA){
        this.id=locationJPA.getId();
        this.city=locationJPA.getCity();
        this.building=locationJPA.getBuilding();
        this.shelving=locationJPA.getShelving();
        this.floor=locationJPA.getFloor();

        this.locationJPA=locationJPA;
    }

    public void updateWith(Location updatedLocation) {
        if (updatedLocation.getCity() != null) this.city = updatedLocation.getCity();
        if (updatedLocation.getBuilding() != null) this.building = updatedLocation.getBuilding();
        if (updatedLocation.getShelving() != null) this.shelving = updatedLocation.getShelving();
        if (updatedLocation.getFloor() != null) this.floor = updatedLocation.getFloor();
    }
}

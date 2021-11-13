package com.xbidi.spring.content.Location.domain;

import com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mstr_location")
public class LocationJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @GenericGenerator(
            name = "location_seq",
            strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                            value = "1"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "LOC"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%08d")
            })

    @Column(name = "id")
    private String id;

    @Column(name="city")
    private String city;

    @Column(name="building")
    private String building;

    @Column(name="shelving")
    private String shelving;

    @Column(name="floor")
    private String floor;

    public LocationJPA(Location location){
        this.id=location.getId();
        this.city=location.getCity();
        this.building=location.getBuilding();
        this.shelving=location.getShelving();
        this.floor=location.getFloor();
    }
}

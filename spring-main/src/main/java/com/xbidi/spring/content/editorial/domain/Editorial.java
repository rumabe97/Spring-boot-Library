package com.xbidi.spring.content.editorial.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Editorial {

    private String id;
    private String name;
    private String direction;
    private String telephone;
    private String email;

    private EditorialJPA editorialJPA;

    public Editorial(EditorialJPA editorialJPA){
        this.id=editorialJPA.getId();
        this.name=editorialJPA.getName();
        this.direction=editorialJPA.getDirection();
        this.telephone=editorialJPA.getTelephone();
        this.email=editorialJPA.getEmail();
    }

    public void updateWith(Editorial updatedEditorial) {
        if (updatedEditorial.getName() != null) this.name = updatedEditorial.getName();
        if (updatedEditorial.getDirection() != null) this.direction = updatedEditorial.getDirection();
        if (updatedEditorial.getTelephone() != null) this.telephone = updatedEditorial.getTelephone();
        if (updatedEditorial.getEmail() != null) this.email = updatedEditorial.getEmail();
    }
}

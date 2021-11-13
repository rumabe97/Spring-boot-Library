package com.xbidi.spring.content.editorial.infrastructure.controller.dto;

import com.xbidi.spring.content.editorial.domain.Editorial;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditorialOutputDTO {
    private String id;
    private String name;
    private String direction;
    private String telephone;
    private String email;

    public EditorialOutputDTO(Editorial editorial){
        this.id=editorial.getId();
        this.name=editorial.getName();
        this.direction=editorial.getDirection();
        this.telephone=editorial.getTelephone();
        this.email=editorial.getEmail();
    }
}

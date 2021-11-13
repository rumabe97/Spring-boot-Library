package com.xbidi.spring.content.editorial.infrastructure.controller.dto;

import com.xbidi.spring.content.editorial.domain.Editorial;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditorialInputDTO {
    private String name;
    private String direction;
    private String telephone;
    private String email;

    public Editorial toEditorial(){
        Editorial editorial = new Editorial();
        editorial.setName(this.name);
        editorial.setDirection(this.direction);
        editorial.setTelephone(this.telephone);
        editorial.setEmail(this.email);
        return editorial;
    }
}

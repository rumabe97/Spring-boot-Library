package com.xbidi.spring.content.author.infrastructure.controller.dto;

import com.xbidi.spring.content.author.domain.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorOutputDTO {
    private String id;
    private String name;
    private String surname;

    public AuthorOutputDTO(Author author){
        this.id=author.getId();
        this.name=author.getName();
        this.surname=author.getSurname();
    }
}

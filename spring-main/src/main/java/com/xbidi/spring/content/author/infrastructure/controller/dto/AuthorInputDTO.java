package com.xbidi.spring.content.author.infrastructure.controller.dto;

import com.xbidi.spring.content.author.domain.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorInputDTO {
    private String name;
    private String surname;

    public Author toAuthor(){
        Author author = new Author();

        author.setName(this.name);
        author.setSurname(this.surname);

        return author;
    }
}

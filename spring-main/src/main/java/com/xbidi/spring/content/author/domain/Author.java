package com.xbidi.spring.content.author.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String id;
    private String name;
    private String surname;

    private AuthorJPA authorJPA;

    public Author(AuthorJPA authorJPA){
        this.id=authorJPA.getId();
        this.name=authorJPA.getName();
        this.surname=authorJPA.getSurname();
    }

    public void updateWith(Author updatedAuthor) {
        if (updatedAuthor.getName() != null) this.name = updatedAuthor.getName();
        if (updatedAuthor.getSurname() != null) this.surname = updatedAuthor.getSurname();
    }
}

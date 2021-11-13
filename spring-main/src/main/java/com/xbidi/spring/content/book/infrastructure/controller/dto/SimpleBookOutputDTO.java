package com.xbidi.spring.content.book.infrastructure.controller.dto;

import com.xbidi.spring.content.book.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleBookOutputDTO {
    private String id;
    private String ISBN;
    private String title;
    private String country;
    private String type;
    private String idEditorial;
    private String idLocation;
    private String idAuthor;
    private String edition;
    private String area;
    private String description;
    private String imageLink;

    public SimpleBookOutputDTO(Book book){
        this.id= book.getId();;
        this.ISBN=book.getISBN();
        this.title=book.getTitle();
        this.country=book.getCountry();
        this.type=book.getType();
        this.edition=book.getEdition();
        this.area=book.getArea();
        this.idEditorial=book.getIdEditorial();
        this.idLocation=book.getIdLocation();
        this.idAuthor=book.getIdAuthor();
        this.description=book.getDescription();
        this.imageLink=book.getImageLink();
    }
}

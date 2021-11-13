package com.xbidi.spring.content.book.infrastructure.controller.dto;

import com.xbidi.spring.content.book.domain.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookInputDTO {
    private String ISBN;
    private String title;
    private String type;
    private String country;
    private String edition;
    private String area;
    private String idAuthor;
    private String idEditorial;
    private String idLocation;
    private String description;
    private String imageLink;

    public Book toBook(){
        Book book = new Book();

        book.setISBN(this.ISBN);
        book.setTitle(this.title);
        book.setType(this.type);
        book.setCountry(this.country);
        book.setEdition(this.edition);
        book.setArea(this.area);
        book.setIdAuthor(this.idAuthor);
        book.setIdEditorial(this.idEditorial);
        book.setIdLocation(this.idLocation);
        book.setDescription(this.description);
        book.setImageLink(this.imageLink);
        return book;
    }
}

package com.xbidi.spring.content.book.domain;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.domain.LocationJPA;
import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.domain.AuthorJPA;
import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
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

    private BookJPA bookJPA;
    private Editorial editorial;
    private Location location;
    private Author author;

    public Book (BookJPA bookJPA){
        this.id=bookJPA.getId();
        this.ISBN=bookJPA.getISBN();
        this.title=bookJPA.getTitle();
        this.type=bookJPA.getType();
        this.country=bookJPA.getCountry();
        this.edition=bookJPA.getEdition();
        this.area=bookJPA.getArea();
        this.idAuthor=bookJPA.getIdAuthor();
        this.idEditorial=bookJPA.getIdEditorial();
        this.idLocation=bookJPA.getIdLocation();
        this.description=bookJPA.getDescription();
        this.imageLink=bookJPA.getImageLink();

        this.bookJPA=bookJPA;
    }

    public Editorial getEditorial(){
        if(editorial!=null) return this.editorial;
        if(bookJPA==null) return null;
        EditorialJPA editorialJPA = bookJPA.getEditorialJPA();
        if(editorialJPA==null) return null;
        Editorial editorial = new Editorial(editorialJPA);
        this.setEditorial(editorial);
        return this.editorial;
    }

    public Location getLocation(){
        if(location!=null) return this.location;
        if(bookJPA==null) return null;
        LocationJPA locationJPA = bookJPA.getLocationJPA();
        if(locationJPA==null) return null;
        Location location = new Location(locationJPA);
        this.setLocation(location);
        return this.location;
    }

    public Author getAuthor(){
        if(author!=null) return this.author;
        if(bookJPA==null) return null;
        AuthorJPA authorJPA = bookJPA.getAuthorJpa();
        if(authorJPA==null) return null;
        Author author = new Author(authorJPA);
        this.setAuthor(author);
        return this.author;
    }
    public void updateWith(Book updatedBook) {
        if (updatedBook.getISBN() != null) this.ISBN = updatedBook.getISBN();
        if (updatedBook.getTitle() != null) this.title = updatedBook.getTitle();
        if (updatedBook.getType() != null) this.type = updatedBook.getType();
        if (updatedBook.getCountry() != null) this.country = updatedBook.getCountry();
        if (updatedBook.getEdition() != null) this.edition = updatedBook.getEdition();
        if (updatedBook.getArea() != null) this.area = updatedBook.getArea();
        if (updatedBook.getIdAuthor() != null) this.idAuthor= updatedBook.getIdAuthor();
        if (updatedBook.getIdEditorial() != null) this.idEditorial = updatedBook.getIdEditorial();
        if (updatedBook.getIdLocation()!=null) this.idLocation=updatedBook.getIdLocation();
        if(updatedBook.getDescription()!=null) this.description=updatedBook.getDescription();
        if(updatedBook.getImageLink()!=null) this.imageLink=updatedBook.getImageLink();
    }
}

package com.xbidi.spring.content.book.infrastructure.controller.dto;

import com.xbidi.spring.content.Location.infrastructure.controller.dto.LocationOutputDTO;
import com.xbidi.spring.content.author.infrastructure.controller.dto.AuthorOutputDTO;
import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookOutputDTO extends  SimpleBookOutputDTO{

    private EditorialOutputDTO editorial;
    private LocationOutputDTO location;
    private AuthorOutputDTO author;

    public BookOutputDTO(Book book){
        super(book);
        if (book.getEditorial()!= null){
            this.editorial = new EditorialOutputDTO(book.getEditorial());
        }
        if(book.getLocation()!=null){
            this.location=new LocationOutputDTO(book.getLocation());
        }
        if(book.getAuthor()!=null){
            this.author=new AuthorOutputDTO(book.getAuthor());
        }
    }
}

package com.xbidi.spring.content.lending.infrastructure.controller.dto;


import com.xbidi.spring.content.book.infrastructure.controller.dto.BookOutputDTO;
import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LendingOutputDTO extends SimpleLendingOutputDTO{

  private UserOutputDTO user;
  private BookOutputDTO book;

  public LendingOutputDTO(Lending lending){
    super(lending);
    if (lending.getUser()!= null){
      this.user = new UserOutputDTO(lending.getUser());
    }
    if(lending.getBook()!=null){
      this.book=new BookOutputDTO(lending.getBook());
    }
  }
}

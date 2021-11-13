package com.xbidi.spring.content.lending.domain;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.domain.BookJPA;
import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.domain.UserJpa;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Lending {
  private String id;
  private String idBook;
  private String idUser;
  private String state;
  private Date startDate;
  private Date endDate;

  private LendingJPA lendingJPA;
  private User user;
  private Book book;

  public Lending(LendingJPA lendingJPA) {
    this.id = lendingJPA.getId();
    this.idUser = lendingJPA.getIdUser();
    this.idBook = lendingJPA.getIdBook();
    this.state = lendingJPA.getState();
    this.startDate=lendingJPA.getStartDate();
    this.endDate=lendingJPA.getEndDate();

    this.lendingJPA = lendingJPA;
  }

  public User getUser() {
    if (user != null) return user;
    if (lendingJPA == null) return null;
    UserJpa userJPA = lendingJPA.getUserJPA();
    if (userJPA == null) return null;
    User user = new User(userJPA);
    this.setUser(user);
    return this.user;
  }

  public Book getBook(){
    if(book != null) return book;
    if(lendingJPA==null) return null;
    BookJPA bookJPA = lendingJPA.getBookJPA();
    if(bookJPA==null) return null;
    Book book = new Book(bookJPA);
    this.setBook(book);
    return this.book;
  }

  public void updateWith(Lending updatedLending) {
    if (updatedLending.getIdUser() != null) this.idUser = updatedLending.getIdUser();
    if (updatedLending.getState() != null) this.state = updatedLending.getState();
    if (updatedLending.getStartDate() != null) this.startDate = updatedLending.getStartDate();
    if (updatedLending.getEndDate() != null) this.endDate = updatedLending.getEndDate();
  }
}

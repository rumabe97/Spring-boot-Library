package com.xbidi.spring.content.user.domain;

import com.xbidi.spring.content.lending.domain.LendingJPA;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String id;
  private String name;
  private String surname;
  private String telephone;
  private String email;
  private String direction;
  private String password;

  private List<LendingJPA> lendings;
  private UserJpa userJpa;

  public User(UserJpa userJpa) {
    this.id = userJpa.getId();
    this.name = userJpa.getName();
    this.surname = userJpa.getSurname();
    this.telephone=userJpa.getTelephone();
    this.email=userJpa.getEmail();
    this.direction=userJpa.getDirection();
    this.password=userJpa.getPassword();
    this.userJpa = userJpa;
  }

  public void updateWith(User updatedUser) {
    if (updatedUser.getName() != null) this.name = updatedUser.getName();
    if (updatedUser.getSurname() != null) this.surname = updatedUser.getSurname();
    if (updatedUser.getEmail() != null) this.email = updatedUser.getEmail();
    if (updatedUser.getTelephone() != null) this.telephone = updatedUser.getTelephone();
    if (updatedUser.getDirection() != null) this.direction = updatedUser.getDirection();
    if(updatedUser.getLendings()!=null) this.lendings=updatedUser.getLendings();
    if(updatedUser.getPassword()!=null) this.password=updatedUser.getPassword();
  }
}

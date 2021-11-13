package com.xbidi.spring.content.user.infrastructure.controller.dto;


import com.xbidi.spring.content.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInputDTO {
  private String name;
  private String surname;
  private String telephone;
  private String email;
  private String direction;
  private String password;

  public User toUser() {
    User user = new User();
    user.setName(this.name);
    user.setSurname(this.surname);
    user.setTelephone(this.telephone);
    user.setEmail(this.email);
    user.setDirection(this.direction);
    user.setPassword(this.password);

    return user;
  }
}

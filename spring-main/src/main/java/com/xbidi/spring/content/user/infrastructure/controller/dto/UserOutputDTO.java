package com.xbidi.spring.content.user.infrastructure.controller.dto;


import com.xbidi.spring.content.lending.infrastructure.controller.dto.SimpleLendingOutputDTO;
import com.xbidi.spring.content.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserOutputDTO {
  private String id;
  private String name;
  private String surname;
  private String telephone;
  private String email;
  private String direction;
  private String password;

  private List<SimpleLendingOutputDTO> lendings;

  public UserOutputDTO(User user){
    this.id = user.getId();
    this.name=user.getName();
    this.surname=user.getSurname();
    this.telephone=user.getTelephone();
    this.email=user.getEmail();
    this.direction=user.getDirection();
    this.password=user.getPassword();
  }
}

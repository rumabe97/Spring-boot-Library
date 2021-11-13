package com.xbidi.spring.content.lending.infrastructure.controller.dto;


import com.xbidi.spring.content.lending.domain.Lending;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class SimpleLendingOutputDTO {
  private String id;
  private String idBook;
  private String idUser;
  private String state;
  private Date startDate;
  private Date endDate;

  public SimpleLendingOutputDTO(Lending lending){
    this.id = lending.getId();
    this.idUser = lending.getIdUser();
    this.idBook=lending.getIdBook();
    this.state = lending.getState();
    this.startDate=lending.getStartDate();
    this.endDate=lending.getEndDate();
  }
}

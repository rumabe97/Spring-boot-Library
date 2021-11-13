package com.xbidi.spring.content.lending.infrastructure.controller.dto;


import com.xbidi.spring.content.lending.domain.Lending;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class LendingInputDTO {
  private String idBook;
  private String idUser;
  private String state;
  private Date startdate;
  private Date endDate;

  public Lending toLending() {
    Lending lending = new Lending();
    lending.setIdUser(this.idUser);
    lending.setIdBook(this.idBook);
    lending.setState(this.state);
    lending.setStartDate(this.startdate);
    lending.setEndDate(this.endDate);
    return lending;
  }
}

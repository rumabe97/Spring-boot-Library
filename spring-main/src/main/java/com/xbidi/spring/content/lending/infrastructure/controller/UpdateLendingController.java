package com.xbidi.spring.content.lending.infrastructure.controller;


import com.xbidi.spring.content.lending.application.port.UpdateLendingPort;
import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingInputDTO;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Lending"})
public class UpdateLendingController {

  private UpdateLendingPort updateLendingPort;

  @PutMapping("lending/{id}")
  @Transactional(rollbackFor = Exception.class)
  public LendingOutputDTO update(@PathVariable("id") String id, @RequestBody LendingInputDTO lendingInputDTO)
      throws Exception {
    Lending lendingValuesUpdated = lendingInputDTO.toLending();
    Lending lendingUpdated = updateLendingPort.update(id, lendingValuesUpdated);
    return new LendingOutputDTO(lendingUpdated);
  }

  //TODO CONFIRMATION
}

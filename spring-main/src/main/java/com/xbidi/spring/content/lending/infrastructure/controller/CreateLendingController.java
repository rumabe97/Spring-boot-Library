package com.xbidi.spring.content.lending.infrastructure.controller;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingInputDTO;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.SimpleLendingOutputDTO;
import com.xbidi.spring.content.lending.infrastructure.repository.port.SaveLendigPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Lending"})
public class CreateLendingController {

  private SaveLendigPort saveLendigPort;

  @PostMapping("lending/create")
  @Transactional(rollbackFor = Exception.class)
  public SimpleLendingOutputDTO create(@RequestBody LendingInputDTO lendingInputDTO) throws Exception {
    Lending lending = lendingInputDTO.toLending();
    Lending createdLendig = saveLendigPort.save(lending);
    return new SimpleLendingOutputDTO(createdLendig);
  }

}

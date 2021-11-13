package com.xbidi.spring.content.lending.infrastructure.controller;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingOutputDTO;
import com.xbidi.spring.content.lending.infrastructure.repository.port.FindLendingPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Lending"})
@RequestMapping("Lending")
public class FindLendingController {

  private FindLendingPort findLendingPort;

  @GetMapping("{id}")
  @Transactional(rollbackFor = Exception.class)
  public LendingOutputDTO findById(@PathVariable("id") String id) throws Exception {
    Lending lending = findLendingPort.findById(id);
    return new LendingOutputDTO(lending);
  }
}

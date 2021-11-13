package com.xbidi.spring.content.user.infrastructure.controller;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserOutputDTO;
import com.xbidi.spring.content.user.infrastructure.repository.port.FindUserPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"User"})
@RequestMapping("user")
public class FindUserController {

  private FindUserPort findUserPort;

  @GetMapping("{id}")
  @Transactional(rollbackFor = Exception.class)
  public UserOutputDTO findById(@PathVariable("id") String id) throws Exception {
    User user = findUserPort.findById(id);
    return new UserOutputDTO(user);
  }
}

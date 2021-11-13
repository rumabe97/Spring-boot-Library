package com.xbidi.spring.content.user.infrastructure.controller;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserInputDTO;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserOutputDTO;
import com.xbidi.spring.content.user.infrastructure.repository.port.SaveUserPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"User"})
public class CreateUserController {

  private SaveUserPort saveUserPort;
  //private CreateCategoryUserPort createCategoryUserPort;

  @PostMapping("user/create")
  @Transactional(rollbackFor = Exception.class)
  public UserOutputDTO create(@RequestBody UserInputDTO userInputDTO) throws Exception {
    User user = userInputDTO.toUser();
    User createdUser = saveUserPort.save(user);
    return new UserOutputDTO(createdUser);
  }
}

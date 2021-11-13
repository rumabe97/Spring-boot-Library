package com.xbidi.spring.content.user.infrastructure.controller;


import com.xbidi.spring.content.user.application.port.UpdateUserPort;
import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserInputDTO;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"User"})
public class UpdateUserController {

  private UpdateUserPort updateUserPort;

  @PutMapping("user/{id}")
  @Transactional(rollbackFor = Exception.class)
  public UserOutputDTO update(@PathVariable("id") String id, @RequestBody UserInputDTO userInputDTO)
      throws Exception {
    User userValuesUpdated = userInputDTO.toUser();
    User userUpdated = updateUserPort.update(id, userValuesUpdated);
    return new UserOutputDTO(userUpdated);
  }

  //TODO CONFIRMATION
}

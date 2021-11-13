package com.xbidi.spring.content.user.infrastructure.controller;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserInputDTO;
import com.xbidi.spring.content.user.infrastructure.controller.dto.UserOutputDTO;
import com.xbidi.spring.content.user.infrastructure.repository.port.SearchUserPort;
import com.xbidi.spring.shared.dto.PagedListDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Api(tags = {"User"})
@RequestMapping("user")
public class SearchUserController {

    private SearchUserPort searchUserPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<UserOutputDTO> search(
        UserInputDTO userInputDTO,
        @RequestParam (name="page", defaultValue = "0") int page,
        @RequestParam(name="size", defaultValue = "10") int size){
        User user = userInputDTO.toUser();
        Page<User> userPage = searchUserPort.search(user, page, size);
        List<UserOutputDTO> userOutputDTOS = userPage.stream().map(UserOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(userOutputDTOS, userPage.getTotalElements(), userPage.getTotalPages());
    }
}

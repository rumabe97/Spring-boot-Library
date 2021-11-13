package com.xbidi.spring.content.lending.infrastructure.controller;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingInputDTO;
import com.xbidi.spring.content.lending.infrastructure.controller.dto.LendingOutputDTO;
import com.xbidi.spring.content.lending.infrastructure.repository.port.SearchLendingPort;
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
@Api(tags = {"Lending"})
@RequestMapping("Lending")
public class SearchLendingController {

    private SearchLendingPort searchLendingPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<LendingOutputDTO> search(
        LendingInputDTO lendingInputDTO,
        @RequestParam (name="page", defaultValue = "0") int page,
        @RequestParam(name="size", defaultValue = "10") int size){
        Lending lending = lendingInputDTO.toLending();
        Page<Lending> lendingPage = searchLendingPort.search(lending, page, size);
        List<LendingOutputDTO> lendingOutputDTOS = lendingPage.stream().map(LendingOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(lendingOutputDTOS, lendingPage.getTotalElements(), lendingPage.getTotalPages());
    }
}

package com.xbidi.spring.content.editorial.infrastructure.controller;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialInputDTO;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialOutputDTO;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.SearchEditorialPort;
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
@Api(tags = {"Editorial"})
@RequestMapping("editorial")
public class SearchEditorialController {

    private SearchEditorialPort searchEditorialPort;

    @GetMapping("search")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public PagedListDTO<EditorialOutputDTO> search(
            EditorialInputDTO editorialInputDTO,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "10") int size){
        Editorial editorial = editorialInputDTO.toEditorial();
        Page<Editorial> editorialPage = searchEditorialPort.search(editorial, page, size);
        List<EditorialOutputDTO> editorialOutputDTOS = editorialPage.stream().map(EditorialOutputDTO::new).collect(Collectors.toList());
        return new PagedListDTO(editorialOutputDTOS, editorialPage.getTotalElements(), editorialPage.getTotalPages());
    }
}

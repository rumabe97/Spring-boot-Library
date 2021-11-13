package com.xbidi.spring.content.editorial.infrastructure.controller;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialOutputDTO;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.FindEditorialPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Editorial"})
@RequestMapping("editorial")
public class FindEditorialController {
    private FindEditorialPort findEditorialPort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public EditorialOutputDTO findById(@PathVariable("id") String id) throws Exception {
        Editorial editorial = findEditorialPort.findById(id);
        return new EditorialOutputDTO(editorial);
    }
}

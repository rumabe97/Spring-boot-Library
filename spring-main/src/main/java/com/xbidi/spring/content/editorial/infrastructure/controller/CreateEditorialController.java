package com.xbidi.spring.content.editorial.infrastructure.controller;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialInputDTO;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialOutputDTO;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.SaveEditorialPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Editorial"})
public class CreateEditorialController {
    private SaveEditorialPort saveEditorialPort;

    @PostMapping("editorial/create")
    @Transactional(rollbackFor = Exception.class)
    public EditorialOutputDTO create(@RequestBody EditorialInputDTO editorialInputDTO) throws Exception {
        Editorial editorial = editorialInputDTO.toEditorial();
        Editorial createdEditorial = saveEditorialPort.save(editorial);
        return new EditorialOutputDTO(createdEditorial);
    }
}

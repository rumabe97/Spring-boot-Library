package com.xbidi.spring.content.editorial.infrastructure.controller;

import com.xbidi.spring.content.editorial.application.port.UpdateEditorialPort;
import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialInputDTO;
import com.xbidi.spring.content.editorial.infrastructure.controller.dto.EditorialOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Api(tags = {"Editorial"})
public class UpdateEditorialController {

    private UpdateEditorialPort updateEditorialPort;

    @PutMapping("editorial/{id}")
    @Transactional(rollbackFor = Exception.class)
    public EditorialOutputDTO update(@PathVariable("id") String id, @RequestBody EditorialInputDTO editorialInputDTO)
            throws Exception {
        Editorial editorialValuesUpdated = editorialInputDTO.toEditorial();
        Editorial editorialUpdated = updateEditorialPort.update(id, editorialValuesUpdated);
        return new EditorialOutputDTO(editorialUpdated);
    }

    //TODO CONFIRMATION
}
package com.xbidi.spring.content.editorial.application;

import com.xbidi.spring.content.editorial.application.port.UpdateEditorialPort;
import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.FindEditorialPort;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.SaveEditorialPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateEditorialUserCase implements UpdateEditorialPort {
    private FindEditorialPort findEditorialPort;
    private SaveEditorialPort saveEditorialPort;

    @Override
    public Editorial update(String idEditorial, Editorial updatedValuesEditorial) throws Exception {
        Editorial currentEditorial = findEditorialPort.findById(idEditorial);
        currentEditorial.updateWith(updatedValuesEditorial);
        Editorial updatedEditorial = saveEditorialPort.save(currentEditorial);
        return updatedEditorial;
    }
}

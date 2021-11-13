package com.xbidi.spring.content.lending.application;

import com.xbidi.spring.content.lending.application.port.UpdateLendingPort;
import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.infrastructure.repository.port.FindLendingPort;
import com.xbidi.spring.content.lending.infrastructure.repository.port.SaveLendigPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateLendingUseCase implements UpdateLendingPort {

    private FindLendingPort findLendingPort;
    private SaveLendigPort saveLendigPort;

    @Override
    public Lending update(String idLending, Lending updatedValuesLending) throws Exception {
        Lending currentLending = findLendingPort.findById(idLending);
        currentLending.updateWith(updatedValuesLending);
        Lending updatedLending = saveLendigPort.save(currentLending);
        return updatedLending;
    }
}

package com.xbidi.spring.content.user.application;

import com.xbidi.spring.content.user.application.port.UpdateUserPort;
import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.infrastructure.repository.port.FindUserPort;
import com.xbidi.spring.content.user.infrastructure.repository.port.SaveUserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCase implements UpdateUserPort {

    private FindUserPort findUserPort;
    private SaveUserPort saveUserPort;

    @Override
    public User update(String idUser, User updatedValuesUser) throws Exception {
        User currentUser = findUserPort.findById(idUser);
        currentUser.updateWith(updatedValuesUser);
        User updatedUser = saveUserPort.save(currentUser);
        return updatedUser;
    }
}

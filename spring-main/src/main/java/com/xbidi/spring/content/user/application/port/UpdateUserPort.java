package com.xbidi.spring.content.user.application.port;

import com.xbidi.spring.content.user.domain.User;

public interface UpdateUserPort {
    User update(String idUser, User user) throws Exception;
}

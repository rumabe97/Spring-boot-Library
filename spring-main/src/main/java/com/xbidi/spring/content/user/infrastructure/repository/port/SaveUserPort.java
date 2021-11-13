package com.xbidi.spring.content.user.infrastructure.repository.port;


import com.xbidi.spring.content.user.domain.User;

public interface SaveUserPort {
    User save(User user);
}

package com.xbidi.spring.content.user.infrastructure.repository.port;


import com.xbidi.spring.content.user.domain.User;
import org.springframework.data.domain.Page;

public interface SearchUserPort {
  Page<User> search(User user, int page, int size);
}

package com.xbidi.spring.content.user.infrastructure.repository;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.domain.UserJpa;
import com.xbidi.spring.content.user.infrastructure.repository.jpa.UserRepositoryJpa;
import com.xbidi.spring.content.user.infrastructure.repository.port.SaveUserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveUserRepository implements SaveUserPort {

  private UserRepositoryJpa userRepositoryJpa;

  @Override
  public User save(User user) {
    UserJpa userJpa = new UserJpa(user);
    UserJpa userSaved = userRepositoryJpa.save(userJpa);
    return new User(userSaved);
  }
}

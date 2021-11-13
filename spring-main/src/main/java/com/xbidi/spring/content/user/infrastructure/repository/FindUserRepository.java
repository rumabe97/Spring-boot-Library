package com.xbidi.spring.content.user.infrastructure.repository;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.domain.UserJpa;
import com.xbidi.spring.content.user.infrastructure.repository.jpa.UserRepositoryJpa;
import com.xbidi.spring.content.user.infrastructure.repository.port.FindUserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindUserRepository implements FindUserPort {

    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public User findById(String id) throws Exception {
        UserJpa userJpa = userRepositoryJpa.findById(id).orElseThrow(()-> new Exception("User not found with id: " + id));
        return new User(userJpa);
    }
}

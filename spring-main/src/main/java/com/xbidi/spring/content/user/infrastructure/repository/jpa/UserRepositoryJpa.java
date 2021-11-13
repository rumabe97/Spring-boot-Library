package com.xbidi.spring.content.user.infrastructure.repository.jpa;


import com.xbidi.spring.content.user.domain.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserJpa, String> {
}

package com.xbidi.spring.content.lending.infrastructure.repository.jpa;


import com.xbidi.spring.content.lending.domain.LendingJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRepositoryJpa extends JpaRepository<LendingJPA, String> {
}

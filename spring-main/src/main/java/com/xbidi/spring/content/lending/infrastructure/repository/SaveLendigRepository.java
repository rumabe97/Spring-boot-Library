package com.xbidi.spring.content.lending.infrastructure.repository;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.domain.LendingJPA;
import com.xbidi.spring.content.lending.infrastructure.repository.jpa.LendingRepositoryJpa;
import com.xbidi.spring.content.lending.infrastructure.repository.port.SaveLendigPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveLendigRepository implements SaveLendigPort {

  private LendingRepositoryJpa lendingRepositoryJpa;

  @Override
  public Lending save(Lending lending) {
    LendingJPA lendingJPA = new LendingJPA(lending);
    LendingJPA lendingSaved = lendingRepositoryJpa.save(lendingJPA);
    return new Lending(lendingSaved);
  }
}

package com.xbidi.spring.content.lending.infrastructure.repository;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.domain.LendingJPA;
import com.xbidi.spring.content.lending.infrastructure.repository.jpa.LendingRepositoryJpa;
import com.xbidi.spring.content.lending.infrastructure.repository.port.FindLendingPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindLendingRepository implements FindLendingPort {

    private LendingRepositoryJpa lendingRepositoryJpa;

    @Override
    public Lending findById(String id) throws Exception {
        LendingJPA lendingJpa = lendingRepositoryJpa.findById(id).orElseThrow(()-> new Exception("Lending not found with id: " + id));
        return new Lending(lendingJpa);
    }
}

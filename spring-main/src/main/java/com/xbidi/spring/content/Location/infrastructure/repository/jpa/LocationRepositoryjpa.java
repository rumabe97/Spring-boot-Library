package com.xbidi.spring.content.Location.infrastructure.repository.jpa;


import com.xbidi.spring.content.Location.domain.LocationJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositoryjpa extends JpaRepository<LocationJPA, String> {
}

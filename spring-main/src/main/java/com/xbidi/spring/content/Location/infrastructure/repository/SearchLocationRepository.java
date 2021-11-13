package com.xbidi.spring.content.Location.infrastructure.repository;

import com.xbidi.spring.content.Location.domain.Location;
import com.xbidi.spring.content.Location.domain.LocationJPA;
import com.xbidi.spring.content.Location.infrastructure.repository.port.SearchLocationPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SearchLocationRepository implements SearchLocationPort {

    private final EntityManager entityManager;

    @Override
    public Page<Location> search(Location location, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LocationJPA> criteriaQuery = criteriaBuilder.createQuery(LocationJPA.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        List<Predicate> predicateList = new ArrayList<>();
        Root<LocationJPA> root =
                predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, location);

        String orderByField = "id";
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

        List<LocationJPA> locationJpas =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        Root<LocationJPA> rootCount =
                predicateBuilder(
                        criteriaBuilder,
                        criteriaQueryCount,
                        predicateList,
                        location);

        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(predicateList.toArray(new Predicate[] {}));

        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
        List<Location> locations = locationJpas.stream().map(Location::new).collect(Collectors.toList());

        return new PageImpl<>(locations, PageRequest.of(page, size), maxResults);
    }

    private Root<LocationJPA> predicateBuilder(
            CriteriaBuilder criteriaBuilder,
            CriteriaQuery<?> criteriaQuery,
            List<Predicate> predicateList,
            Location location) {
        Root<LocationJPA> root = criteriaQuery.from(LocationJPA.class);

        // WHERE
        if (location.getCity()!=null) predicateList.add(criteriaBuilder.like(root.get("city"),'%'+location.getCity()+'%'));
        if (location.getBuilding()!=null) predicateList.add(criteriaBuilder.like(root.get("building"),'%'+location.getBuilding()+'%'));
        if (location.getShelving()!=null) predicateList.add(criteriaBuilder.like(root.get("shelving"),'%'+location.getShelving()+'%'));
        if (location.getFloor()!=null) predicateList.add(criteriaBuilder.like(root.get("floor"),'%'+location.getFloor()+'%'));
        return root;
    }
}

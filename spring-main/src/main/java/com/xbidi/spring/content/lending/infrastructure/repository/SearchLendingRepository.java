package com.xbidi.spring.content.lending.infrastructure.repository;


import com.xbidi.spring.content.lending.domain.Lending;
import com.xbidi.spring.content.lending.domain.LendingJPA;
import com.xbidi.spring.content.lending.infrastructure.repository.port.SearchLendingPort;
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
public class SearchLendingRepository implements SearchLendingPort {

  private final EntityManager entityManager;

  @Override
  public Page<Lending> search(Lending lending, int page, int size) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<LendingJPA> criteriaQuery = criteriaBuilder.createQuery(LendingJPA.class);
    CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

    List<Predicate> predicateList = new ArrayList<>();
    Root<LendingJPA> root =
        predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, lending);

    String orderByField = "id";
    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

    criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

    List<LendingJPA> lendingJpas =
        entityManager
            .createQuery(criteriaQuery)
            .setFirstResult(page * size)
            .setMaxResults(size)
            .getResultList();

    Root<LendingJPA> rootCount =
        predicateBuilder(
            criteriaBuilder,
            criteriaQueryCount,
            predicateList,
            lending);

    criteriaQueryCount
        .select(criteriaBuilder.count(rootCount))
        .where(predicateList.toArray(new Predicate[] {}));

    long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
    List<Lending> lendings = lendingJpas.stream().map(Lending::new).collect(Collectors.toList());

    return new PageImpl<>(lendings, PageRequest.of(page, size), maxResults);
  }

  private Root<LendingJPA> predicateBuilder(
      CriteriaBuilder criteriaBuilder,
      CriteriaQuery<?> criteriaQuery,
      List<Predicate> predicateList,
      Lending lending) {
    Root<LendingJPA> root = criteriaQuery.from(LendingJPA.class);

    // WHERE
    if (lending.getIdUser()!=null) predicateList.add(criteriaBuilder.equal(root.get("idUser"),lending.getIdUser()));
    if (lending.getIdBook()!=null) predicateList.add(criteriaBuilder.equal(root.get("idBook"),lending.getBook()));
    if (lending.getState()!=null) predicateList.add(criteriaBuilder.like(root.get("state"),'%'+lending.getState()+'%'));
    if (lending.getStartDate()!=null) predicateList.add(criteriaBuilder.equal(root.get("startDate"),lending.getStartDate()));
    if (lending.getEndDate()!=null) predicateList.add(criteriaBuilder.equal(root.get("endDate"),lending.getEndDate()));

    return root;
  }
}

package com.xbidi.spring.content.user.infrastructure.repository;


import com.xbidi.spring.content.user.domain.User;
import com.xbidi.spring.content.user.domain.UserJpa;
import com.xbidi.spring.content.user.infrastructure.repository.port.SearchUserPort;
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
public class SearchUserRepository implements SearchUserPort {

  private final EntityManager entityManager;

  @Override
  public Page<User> search(User user, int page, int size) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<UserJpa> criteriaQuery = criteriaBuilder.createQuery(UserJpa.class);
    CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

    List<Predicate> predicateList = new ArrayList<>();
    Root<UserJpa> root =
        predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, user);

    String orderByField = "id";
    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

    criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

    List<UserJpa> userJpas =
        entityManager
            .createQuery(criteriaQuery)
            .setFirstResult(page * size)
            .setMaxResults(size)
            .getResultList();

    Root<UserJpa> rootCount =
        predicateBuilder(
            criteriaBuilder,
            criteriaQueryCount,
            predicateList,
            user);

    criteriaQueryCount
        .select(criteriaBuilder.count(rootCount))
        .where(predicateList.toArray(new Predicate[] {}));

    long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
    List<User> users = userJpas.stream().map(User::new).collect(Collectors.toList());

    return new PageImpl<>(users, PageRequest.of(page, size), maxResults);
  }

  private Root<UserJpa> predicateBuilder(
      CriteriaBuilder criteriaBuilder,
      CriteriaQuery<?> criteriaQuery,
      List<Predicate> predicateList,
      User user) {
    Root<UserJpa> root = criteriaQuery.from(UserJpa.class);

    // WHERE
    if (user.getName()!=null) predicateList.add(criteriaBuilder.like(root.get("name"),'%'+user.getName()+'%'));
    if (user.getSurname()!=null) predicateList.add(criteriaBuilder.like(root.get("surname"),'%'+user.getSurname()+'%'));
    if (user.getTelephone()!=null) predicateList.add(criteriaBuilder.like(root.get("telephone"),'%'+user.getTelephone()+'%'));
    if (user.getEmail()!=null) predicateList.add(criteriaBuilder.equal(root.get("email"),user.getEmail()));
    if (user.getDirection()!=null) predicateList.add(criteriaBuilder.like(root.get("direction"),'%'+user.getDirection()+'%'));
    if (user.getPassword()!=null) predicateList.add(criteriaBuilder.equal(root.get("password"),user.getPassword()));
    return root;
  }
}

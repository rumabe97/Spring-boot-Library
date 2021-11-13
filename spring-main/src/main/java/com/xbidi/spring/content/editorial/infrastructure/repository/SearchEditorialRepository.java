package com.xbidi.spring.content.editorial.infrastructure.repository;

import com.xbidi.spring.content.editorial.domain.Editorial;
import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import com.xbidi.spring.content.editorial.infrastructure.repository.port.SearchEditorialPort;
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
public class SearchEditorialRepository implements SearchEditorialPort {
    private final EntityManager entityManager;

    @Override
    public Page<Editorial> search(Editorial editorial, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EditorialJPA> criteriaQuery = criteriaBuilder.createQuery(EditorialJPA.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        List<Predicate> predicateList = new ArrayList<>();
        Root<EditorialJPA> root =
                predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, editorial);

        String orderByField = "id";
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

        List<EditorialJPA> editorialJPAS =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        Root<EditorialJPA> rootCount =
                predicateBuilder(
                        criteriaBuilder,
                        criteriaQueryCount,
                        predicateList,
                        editorial);

        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(predicateList.toArray(new Predicate[] {}));

        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
        List<Editorial> editorials = editorialJPAS.stream().map(Editorial::new).collect(Collectors.toList());

        return new PageImpl<>(editorials, PageRequest.of(page, size), maxResults);
    }

    private Root<EditorialJPA> predicateBuilder(
            CriteriaBuilder criteriaBuilder,
            CriteriaQuery<?> criteriaQuery,
            List<Predicate> predicateList,
            Editorial editorial) {
        Root<EditorialJPA> root = criteriaQuery.from(EditorialJPA.class);

        // WHERE
        if (editorial.getName()!=null) predicateList.add(criteriaBuilder.like(root.get("name"),'%'+editorial.getName()+'%'));
        if (editorial.getDirection()!=null) predicateList.add(criteriaBuilder.like(root.get("direction"),'%'+editorial.getDirection()+'%'));
        if (editorial.getTelephone()!=null) predicateList.add(criteriaBuilder.like(root.get("telephone"),'%'+editorial.getTelephone()+'%'));
        if (editorial.getEmail()!=null) predicateList.add(criteriaBuilder.like(root.get("email"),'%'+editorial.getEmail()+'%'));
        return root;
    }
}

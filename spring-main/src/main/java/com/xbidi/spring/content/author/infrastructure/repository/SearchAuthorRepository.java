package com.xbidi.spring.content.author.infrastructure.repository;

import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.domain.AuthorJPA;
import com.xbidi.spring.content.author.infrastructure.repository.port.SearchAuthorPort;
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
public class SearchAuthorRepository implements SearchAuthorPort {
    private final EntityManager entityManager;

    @Override
    public Page<Author> search(Author author, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AuthorJPA> criteriaQuery = criteriaBuilder.createQuery(AuthorJPA.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        List<Predicate> predicateList = new ArrayList<>();
        Root<AuthorJPA> root =
                predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, author);

        String orderByField = "id";
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

        List<AuthorJPA> authorJPAS =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        Root<AuthorJPA> rootCount =
                predicateBuilder(
                        criteriaBuilder,
                        criteriaQueryCount,
                        predicateList,
                        author);

        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(predicateList.toArray(new Predicate[] {}));

        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
        List<Author> authors = authorJPAS.stream().map(Author::new).collect(Collectors.toList());

        return new PageImpl<>(authors, PageRequest.of(page, size), maxResults);
    }

    private Root<AuthorJPA> predicateBuilder(
            CriteriaBuilder criteriaBuilder,
            CriteriaQuery<?> criteriaQuery,
            List<Predicate> predicateList,
            Author author) {
        Root<AuthorJPA> root = criteriaQuery.from(AuthorJPA.class);

        // WHERE
        if (author.getName()!=null) predicateList.add(criteriaBuilder.like(root.get("name"),'%'+author.getName()+'%'));
        if (author.getSurname()!=null) predicateList.add(criteriaBuilder.like(root.get("surname"),'%'+author.getSurname()+'%'));
        return root;
    }
}

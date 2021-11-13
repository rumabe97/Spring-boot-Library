package com.xbidi.spring.content.book.infrastructure.repository;

import com.xbidi.spring.content.book.domain.Book;
import com.xbidi.spring.content.book.domain.BookJPA;
import com.xbidi.spring.content.book.infrastructure.repository.port.SearchBookPort;
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
public class SearchBookRepository implements SearchBookPort {

    private final EntityManager entityManager;

    @Override
    public Page<Book> search(Book book, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookJPA> criteriaQuery = criteriaBuilder.createQuery(BookJPA.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        List<Predicate> predicateList = new ArrayList<>();
        Root<BookJPA> root =
                predicateBuilder(criteriaBuilder, criteriaQuery, predicateList, book);

        String orderByField = "id";
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderByField)));

        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[] {}));

        List<BookJPA> bookJpas =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        Root<BookJPA> rootCount =
                predicateBuilder(
                        criteriaBuilder,
                        criteriaQueryCount,
                        predicateList,
                        book);

        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(predicateList.toArray(new Predicate[] {}));

        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();
        List<Book> books = bookJpas.stream().map(Book::new).collect(Collectors.toList());

        return new PageImpl<>(books, PageRequest.of(page, size), maxResults);
    }

    private Root<BookJPA> predicateBuilder(
            CriteriaBuilder criteriaBuilder,
            CriteriaQuery<?> criteriaQuery,
            List<Predicate> predicateList,
            Book book) {
        Root<BookJPA> root = criteriaQuery.from(BookJPA.class);

        // WHERE
        if (book.getId()!=null) predicateList.add(criteriaBuilder.like(root.get("id"),'%'+book.getId()+'%'));
        if (book.getISBN()!=null) predicateList.add(criteriaBuilder.like(root.get("ISBN"),'%'+book.getISBN()+'%'));
        if (book.getTitle()!=null) predicateList.add(criteriaBuilder.like(root.get("title"),'%'+book.getTitle()+'%'));
        if (book.getType()!=null) predicateList.add(criteriaBuilder.like(root.get("type"),'%'+book.getType()+'%'));
        if (book.getCountry()!=null) predicateList.add(criteriaBuilder.like(root.get("country"),'%'+book.getCountry()+'%'));
        if (book.getEdition()!=null) predicateList.add(criteriaBuilder.like(root.get("edition"),'%'+book.getEdition()+'%'));
        if (book.getArea()!=null) predicateList.add(criteriaBuilder.like(root.get("area"),'%'+book.getArea()+'%'));
        if (book.getIdAuthor()!=null) predicateList.add(criteriaBuilder.equal(root.get("idAuthor"),book.getIdAuthor()));
        if (book.getIdEditorial()!=null) predicateList.add(criteriaBuilder.equal(root.get("idEditorial"),book.getIdEditorial()));
        if (book.getDescription()!=null) predicateList.add(criteriaBuilder.equal(root.get("description"),book.getDescription()));
        return root;
    }
}
package com.xbidi.spring.content.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xbidi.spring.content.Location.domain.LocationJPA;
import com.xbidi.spring.content.author.domain.AuthorJPA;
import com.xbidi.spring.content.editorial.domain.EditorialJPA;
import com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mstr_book")
public class BookJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
            name = "book_seq",
            strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                            value = "1"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "BOK"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%08d")
            })

    @Column(name = "id")
    private String id;

    @Column(name="ISBN")
    private String ISBN;

    @Column(name ="title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "country")
    private String country;

    @Column(name = "edition")
    private String edition;

    @Column(name = "area")
    private String area;

    @Column(name = "idAuthor")
    private String idAuthor;

    @Column(name="idEditorial")
    private String idEditorial;

    @Column(name="idLocation")
    private String idLocation;

    @Size(min = 1, max = 50000)
    @Column(name="description", length = 50000)
    private String description;

    @Column(name = "imageLink")
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idEditorial", updatable = false, insertable = false)
    @JsonIgnore
    private EditorialJPA editorialJPA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idLocation", updatable = false, insertable = false)
    @JsonIgnore
    private LocationJPA locationJPA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idAuthor", updatable = false, insertable = false)
    @JsonIgnore
    private AuthorJPA authorJpa;

    public BookJPA(Book book){
        this.id=book.getId();
        this.ISBN=book.getISBN();
        this.title=book.getTitle();
        this.type=book.getType();
        this.country=book.getCountry();
        this.edition=book.getEdition();
        this.area=book.getArea();
        this.idAuthor=book.getIdAuthor();
        this.idEditorial=book.getIdEditorial();
        this.idLocation=book.getIdLocation();
        this.description=book.getDescription();
        this.imageLink=book.getImageLink();
    }
}

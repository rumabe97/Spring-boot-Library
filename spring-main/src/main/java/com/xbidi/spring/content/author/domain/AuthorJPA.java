package com.xbidi.spring.content.author.domain;

import com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mstr_author")
public class AuthorJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @GenericGenerator(
            name = "author_seq",
            strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                            value = "1"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "AUT"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%08d")
            })

    @Column(name = "id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    public AuthorJPA(Author author){
        this.id=author.getId();
        this.name=author.getName();
        this.surname=author.getSurname();
    }
}

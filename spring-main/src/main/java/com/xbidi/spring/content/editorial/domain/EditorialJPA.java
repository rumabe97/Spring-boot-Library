package com.xbidi.spring.content.editorial.domain;

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
@Table(name = "mstr_editorial")
public class EditorialJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editorial_seq")
    @GenericGenerator(
            name = "editorial_seq",
            strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                            value = "1"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                            value = "EDI"),
                    @org.hibernate.annotations.Parameter(
                            name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                            value = "%08d")
            })

    @Column(name = "id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="direction")
    private String direction;

    @Column(name="telephone")
    private String telephone;

    @Column(name="email")
    private String email;

    public EditorialJPA(Editorial editorial){
        this.id=editorial.getId();
        this.name=editorial.getName();
        this.direction=editorial.getDirection();
        this.telephone=editorial.getTelephone();
        this.email=editorial.getEmail();
    }
}

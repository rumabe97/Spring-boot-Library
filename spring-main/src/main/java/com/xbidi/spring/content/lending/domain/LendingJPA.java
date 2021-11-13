package com.xbidi.spring.content.lending.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xbidi.spring.content.book.domain.BookJPA;
import com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator;
import com.xbidi.spring.content.user.domain.UserJpa;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mstr_lending")
public class LendingJPA {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lending_seq")
  @GenericGenerator(
          name = "lending_seq",
          strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
          parameters = {
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                          value = "1"),
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                          value = "LEN"),
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                          value = "%08d")
          })

  @Column(name = "id")
  private String id;

  @Column(name = "id_book")
  private String idBook;

  @Column(name = "id_user")
  private String idUser;

  @Column(name = "state")
  private String state;

  @Column(name="start_date")
  private Date startDate;

  @Column(name="end_date")
  private Date endDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="id_user", updatable = false, insertable = false)
  @JsonIgnore
  private UserJpa userJPA;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="id_book", updatable = false, insertable = false)
  @JsonIgnore
  private BookJPA bookJPA;

  public LendingJPA(Lending lending) {
    this.id = lending.getId();
    this.idBook = lending.getIdBook();
    this.idUser = lending.getIdUser();
    this.state = lending.getState();
    this.endDate=lending.getEndDate();
    this.startDate=lending.getStartDate();
  }
}

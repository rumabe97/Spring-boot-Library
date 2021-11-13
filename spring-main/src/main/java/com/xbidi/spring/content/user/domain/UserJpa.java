package com.xbidi.spring.content.user.domain;

import com.xbidi.spring.content.lending.domain.LendingJPA;
import com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mstr_user")
public class UserJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @GenericGenerator(
          name = "user_seq",
          strategy = "com.xbidi.spring.content.shared.StringPrefixedSequenceIdGenerator",
          parameters = {
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
                          value = "1"),
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
                          value = "USR"),
                  @org.hibernate.annotations.Parameter(
                          name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
                          value = "%08d")
          })

  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "direction")
  private String direction;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "email")
  private String email;

  @Column(name="password")
  private String password;

  @OneToMany(mappedBy = "userJPA", fetch = FetchType.LAZY)
  private List<LendingJPA> lendings;


  public UserJpa(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.surname = user.getSurname();
    this.direction=user.getDirection();
    this.telephone=user.getTelephone();
    this.email=user.getEmail();
    this.lendings=user.getLendings();
    this.password= user.getPassword();
  }
}

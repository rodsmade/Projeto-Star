package br.com.star.crudStar.role;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NaturalId
  @Column(length = 60)
  @Enumerated(EnumType.STRING)
  private RoleName name;

}

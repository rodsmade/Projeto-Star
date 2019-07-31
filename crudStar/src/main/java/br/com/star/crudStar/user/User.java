package br.com.star.crudStar.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.star.crudStar.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "username"
    }),
    @UniqueConstraint(columnNames = {
        "email"
    })
})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 50)
  private String sobrenome;

  @NotBlank
  @Size(max = 15)
  private String handle;

  @Email
  @NotBlank
  @Size(max = 50)
  private String email;

  @NotBlank
  @Size(max = 100)
  private String senha;

  private Date nascimento;
// É uma FOREIGN KEY| resolver depois
  //  private Integer qtdAmigos;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", // TODO - user_roles renomeada para user_role
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

}

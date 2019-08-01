package br.com.star.crudStar.user;

import br.com.star.crudStar.model.DadosPessoais;
import br.com.star.crudStar.model.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import br.com.star.crudStar.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "handle"
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


  @Size(max = 50)
  private String sobrenome;

  @Column(name = "handle")
  @NotBlank
  @Size(max = 15)
  private String username;

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


  @JsonIgnore
  @OneToOne(cascade =  CascadeType.ALL)
  @JoinColumn(name = "id_dados_pessoais")
  private DadosPessoais dadosPessoais;



  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", // TODO - user_roles renomeada para user_role
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
    this.name = name;
    this.sobrenome = sobrenome;
    this.username = username;
    this.email = email;
    this.senha = senha;
    this.nascimento = nascimento;
    this.dadosPessoais = dadosPessoais;
    this.roles = roles;
  }



}

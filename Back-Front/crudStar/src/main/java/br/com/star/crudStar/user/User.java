package br.com.star.crudStar.user;

import br.com.star.crudStar.model.DadosPessoais;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.star.crudStar.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


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
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }
  public String getNascimento(){
    return nascimento;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setNascimento(String nascimento) {
    this.nascimento = nascimento;
  }


  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

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

  @NotBlank
  @Size(max = 100)
  private String nascimento;

// É uma FOREIGN KEY| resolver depois
  //  private Integer qtdAmigos;

    @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", // TODO - user_roles renomeada para user_role
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
    this.name = name;
    this.username = username;
    this.email = email;
    this.senha = senha;
    this.nascimento = nascimento;
    this.roles = roles;
  }



}

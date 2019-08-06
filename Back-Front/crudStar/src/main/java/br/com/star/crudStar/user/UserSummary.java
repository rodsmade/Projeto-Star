package br.com.star.crudStar.user;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class UserSummary {

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNascimento(){
    return nascimento;
  }

  public void setNascimento(String nascimento) {
    this.nascimento = nascimento;
  }

  private Long id;
  private String username;
  private String name;
  private String nascimento;
}

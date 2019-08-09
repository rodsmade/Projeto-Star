package br.com.star.crudStar.security;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {

  @NotBlank
  @Size(min = 3, max = 40)
  private String name;

  @Column(name = "handle")
  @NotBlank
  @Size(min = 3, max = 15)
  private String username;

  @Email
  @NotBlank
  @Size(max = 40)
  private String email;

  @NotBlank
  @Size(min = 3, max = 20)
  private String password;

  @NotBlank
  private String nascimento;

}

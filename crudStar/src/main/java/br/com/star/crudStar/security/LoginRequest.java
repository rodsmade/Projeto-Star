package br.com.star.crudStar.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

  @NotBlank
  private String handleOrEmail;

  @NotBlank
  private String password;

}

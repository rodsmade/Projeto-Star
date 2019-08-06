package br.com.star.crudStar.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

  private Boolean success;
  private String message;

}

package br.com.star.crudStar.user;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public class UserIdentityAvailability {
  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }



  private Boolean available;

}

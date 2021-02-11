package com.webpacs.api.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @Column(unique = true)
  private String email;
  private String password;
  private String rememberToken;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  public User() { }
  public Long getId() {
    return id;
  }
  public String getName() { return name; }
  public String getEmail() {
    return email;
  }
  public String getPassword() {
    return password;
  }
  public String getRememberToken() {
    return rememberToken;
  }
}

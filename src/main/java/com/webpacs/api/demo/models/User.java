package com.webpacs.api.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
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

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRememberToken() {
    return rememberToken;
  }

  public void setRememberToken(String rememberToken) {
    this.rememberToken = rememberToken;
  }
}

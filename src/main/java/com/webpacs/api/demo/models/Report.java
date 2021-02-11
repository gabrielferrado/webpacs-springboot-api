package com.webpacs.api.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Report {
  @Id
  @GeneratedValue
  private Long id;
  private String content;

  public Report(String content) {
    this.content = content;
  }
  public Report() {}
  public Long getId() {
    return id;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
}

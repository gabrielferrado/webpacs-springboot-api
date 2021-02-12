package com.webpacs.api.demo.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Report {
  @Id
  @GeneratedValue
  private Long id;
  private String content;

  @CreationTimestamp
  private Date createdAt;

  @OneToOne
  @NotNull
  private User user;

  public Report(String content) {
    this.content = content;
  }
  public Report() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}

package com.ap.demoREST;

import java.io.Serializable;

public class StudentId implements Serializable {
  private static final long serialVersionUID = 7123551074231448622L;
  
  private Long id;
  
  private String surname;
  
  StudentId() {}
  
  public StudentId(Long id, String surname) {
    this.id = id;
    this.surname = surname;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getSurname() {
    return this.surname;
  }
  
  public void setSurname(String surname) {
    this.surname = surname;
  }
}

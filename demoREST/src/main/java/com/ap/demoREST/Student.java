package com.ap.demoREST;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(StudentId.class)
public class Student {
  @Id
  private Long id;
  
  @Id
  private String surname;
  
  private String name;
  
  private Integer schoolMark;
  
  Student() {}
  
  public Student(String name, Integer schoolMark) {
    this.name = name;
    this.schoolMark = schoolMark;
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
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Integer getSchoolMark() {
    return this.schoolMark;
  }
  
  public void setSchoolMark(Integer schoolMark) {
    this.schoolMark = schoolMark;
  }
}

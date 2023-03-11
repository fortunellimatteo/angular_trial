package com.ap.demoREST.dto;

public class NotesOfStudent {
  private Long id;
  
  private String title;
  
  private String content;
  
  private String name;
  
  private String surname;
  
  public NotesOfStudent(Long id, String title, String content, String name, String surname) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.name = name;
    this.surname = surname;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSurname() {
    return this.surname;
  }
  
  public void setSurname(String surname) {
    this.surname = surname;
  }
}

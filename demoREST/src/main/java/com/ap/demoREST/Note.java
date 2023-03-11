package com.ap.demoREST;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(NoteId.class)
public class Note {
  @Id
  private Long id;
  
  @Id
  private Long nrOfNote;
  
  private String title;
  
  private String content;
  
  Note() {}
  
  public Note(String title, String content) {
    this.title = title;
    this.content = content;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getNrOfNote() {
    return this.nrOfNote;
  }
  
  public void setNrOfNote(Long nrOfNote) {
    this.nrOfNote = nrOfNote;
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
}

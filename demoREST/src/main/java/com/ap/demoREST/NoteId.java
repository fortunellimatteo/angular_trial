package com.ap.demoREST;

import java.io.Serializable;

public class NoteId implements Serializable {
  private static final long serialVersionUID = -3876518877472158699L;
  
  private Long id;
  
  private Long nrOfNote;
  
  NoteId() {}
  
  public NoteId(Long id, Long nrOfNote) {
    this.id = id;
    this.nrOfNote = nrOfNote;
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
}

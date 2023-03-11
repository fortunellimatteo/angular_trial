package com.ap.demoREST;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
  private final NoteRepository noteRepository;
  
  NoteController(NoteRepository repository) {
    this.noteRepository = repository;
  }
  
  @GetMapping({"/notes"})
  Iterable<Note> getNotes() {
    return this.noteRepository.findAll();
  }
  
  @PostMapping({"/notes"})
  Note createNote(@RequestBody Note newNote) {
    return (Note)this.noteRepository.save(newNote);
  }
  
  @GetMapping({"/notes/{id}"})
  Note getNote(@PathVariable Long id) {
    return (Note)this.noteRepository.findById(id).orElseThrow();
  }
  
  @DeleteMapping({"/notes/{id}"})
  void deleteNote(@PathVariable Long id) {
    this.noteRepository.deleteById(id);
  }
  
  @PutMapping({"/notes/{id}"})
  Note updateNote(@PathVariable Long id, @RequestBody Note newNote) {
    Note noteToUpdate = (Note)this.noteRepository.findById(id).orElseThrow();
    noteToUpdate.setTitle(newNote.getTitle());
    noteToUpdate.setContent(newNote.getContent());
    return (Note)this.noteRepository.save(noteToUpdate);
  }
}

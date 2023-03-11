package com.ap.demoREST;

import com.ap.demoREST.dto.NotesOfStudent;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  private final StudentRepository studentRepository;
  
  public StudentController(StudentRepository repository) {
    this.studentRepository = repository;
  }
  
  @GetMapping({"/students"})
  public Iterable<Student> getStudents() {
    return this.studentRepository.findAll();
  }
  
  @PostMapping({"/students"})
  public Student getStudent(@RequestBody StudentId student) {
    return (Student)this.studentRepository.findById(student).orElseThrow();
  }
  
  @PostMapping({"/students/create"})
  public Student createStudent(@RequestBody Student newStudent) {
    return (Student)this.studentRepository.save(newStudent);
  }
  
  @DeleteMapping({"/students/delete"})
  public void deleteStudent(@RequestBody StudentId student) {
    this.studentRepository.deleteById(student);
  }
  
  @GetMapping({"/notesOfStudent/{id}"})
  public List<NotesOfStudent> getNotesOfStudent(@PathVariable Long id) {
    return this.studentRepository.getNotesOfStudent(id);
  }
}

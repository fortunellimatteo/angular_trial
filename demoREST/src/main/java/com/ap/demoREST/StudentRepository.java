package com.ap.demoREST;

import com.ap.demoREST.dto.NotesOfStudent;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, StudentId> {
  @Query("SELECT new com.ap.demoREST.dto.NotesOfStudent(s.id, n.title, n.content, s.name, s.surname) FROM Student s JOIN Note n ON s.id = n.id WHERE s.id = :id")
  List<NotesOfStudent> getNotesOfStudent(Long id);
}

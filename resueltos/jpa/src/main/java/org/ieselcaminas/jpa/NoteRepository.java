package org.ieselcaminas.jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
    Note findById(long id);
}
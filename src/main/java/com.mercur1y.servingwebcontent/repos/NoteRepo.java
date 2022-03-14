package com.mercur1y.servingwebcontent.repos;

import org.springframework.data.repository.CrudRepository;
import com.mercur1y.servingwebcontent.domain.Note;

import java.util.List;


public interface NoteRepo extends CrudRepository<Note, Long> {
}

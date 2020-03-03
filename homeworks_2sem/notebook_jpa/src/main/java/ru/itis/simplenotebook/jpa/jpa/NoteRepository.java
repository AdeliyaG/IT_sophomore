package ru.itis.simplenotebook.jpa.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.simplenotebook.jpa.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    Page<NoteEntity> findAll(Pageable pageable);

    Page<NoteEntity> findAllByNameContains(String name, Pageable pageable);


}

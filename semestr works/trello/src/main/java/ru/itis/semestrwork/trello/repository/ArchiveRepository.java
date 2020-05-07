package ru.itis.semestrwork.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrwork.trello.entity.Archive;
import ru.itis.semestrwork.trello.entity.Item;

import java.util.List;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {

}

package ru.itis.semestrwork.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrwork.trello.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
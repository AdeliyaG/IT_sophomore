package ru.itis.simpleblog.simple_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.simpleblog.simple_blog.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}

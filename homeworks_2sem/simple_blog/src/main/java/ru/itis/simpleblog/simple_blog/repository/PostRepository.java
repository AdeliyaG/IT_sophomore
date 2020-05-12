package ru.itis.simpleblog.simple_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {

    List<PostEntity> findAll();
    List<PostEntity> findAllByUser_Id(Long user_id);
    List<PostEntity> findAllById(Long post_id);
    PostEntity findByUserId(Long user_id);
}

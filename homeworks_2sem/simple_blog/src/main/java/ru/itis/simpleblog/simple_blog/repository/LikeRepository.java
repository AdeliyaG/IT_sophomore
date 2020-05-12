package ru.itis.simpleblog.simple_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.simpleblog.simple_blog.entity.LikeEntity;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeEntity, Boolean> {

    void deleteByPostLikedId(Long post_id);

    @Query("select l from LikeEntity as l where l.userLike = :user and l.postLiked = :post")
    List<LikeEntity> isUserLikedPost(@Param("user") UserEntity user, @Param("post") PostEntity post);

}

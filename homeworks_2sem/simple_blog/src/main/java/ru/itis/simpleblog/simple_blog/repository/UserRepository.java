package ru.itis.simpleblog.simple_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);
}

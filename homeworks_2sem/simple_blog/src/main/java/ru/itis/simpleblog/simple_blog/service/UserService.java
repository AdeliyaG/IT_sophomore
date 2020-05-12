package ru.itis.simpleblog.simple_blog.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;
import ru.itis.simpleblog.simple_blog.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;


    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public Boolean signUp(UserEntity user) {
        String username = user.getUsername();
        if (username.equals(
                (userRepository.findByUsername(username))
                        .getUsername())) {
            return false;
        } else {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userRepository.save(user);
            return true;
        }
    }

    public String signIn(UserEntity user) {
        UserEntity isFound = userRepository.findByUsernameAndPassword(user.getUsername(),
                DigestUtils.md5Hex(user.getPassword()));
        if (isFound != null) {
            return tokenService.createToken(isFound);
        } else {
            return null;
        }
    }
}

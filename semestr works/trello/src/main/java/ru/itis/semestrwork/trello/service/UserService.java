package ru.itis.semestrwork.trello.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semestrwork.trello.dto.SignInDto;
import ru.itis.semestrwork.trello.dto.SignUpDto;
import ru.itis.semestrwork.trello.dto.TokenDto;
import ru.itis.semestrwork.trello.entity.Role;
import ru.itis.semestrwork.trello.entity.User;
import ru.itis.semestrwork.trello.repository.UserRepository;
import ru.itis.semestrwork.trello.security.JwtTokenProvider;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void signUp(SignUpDto userData) {
        String username = userData.getUsername();
        Optional<User> usernameDB = userRepository.findByUsername(username);
        if (!usernameDB.isPresent()) {
            User user = User.builder()
                    .username(username)
                    .email(userData.getEmail())
                    .hashPassword(passwordEncoder.encode(userData.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
        } else throw new AccessDeniedException("User with this username is already exist");
    }


    public TokenDto signIn(SignInDto userData) {
        Optional<User> userOptional = userRepository.findByUsername(userData.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(jwtTokenProvider.createToken(userData, user));
            tokenDto.setRole(user.getRole().toString());
            return tokenDto;
        } else throw new AccessDeniedException("User is not found");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

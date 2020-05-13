package ru.itis.semestrwork.trello.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrwork.trello.dto.FacebookDto;
import ru.itis.semestrwork.trello.dto.SignInDto;
import ru.itis.semestrwork.trello.dto.SignUpDto;
import ru.itis.semestrwork.trello.dto.TokenDto;
import ru.itis.semestrwork.trello.entity.Role;
import ru.itis.semestrwork.trello.entity.User;
import ru.itis.semestrwork.trello.repository.UserRepository;
import ru.itis.semestrwork.trello.security.JwtTokenProvider;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

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

    public TokenDto signInWithFacebook(FacebookDto facebookDto) {
        System.out.println(facebookDto);
        try {
            Optional<User> userOptional = userRepository.findByUsername(facebookDto.getUsername());
            User user = userOptional.get();
            System.out.println("хочу сайнин");
            return signInForFacebook(facebookDto);
        } catch (NoSuchElementException e) {
            System.out.println("хочу сайнап");
            SignUpDto signUpDto = SignUpDto.builder()
                    .username(facebookDto.getUsername())
                    .email(facebookDto.getEmail())
                    .password(facebookDto.getPassword())
                    .build();
            signUp(signUpDto);
            return signInForFacebook(facebookDto);
        }
    }

    private TokenDto signInForFacebook(FacebookDto facebookDto) {
        Optional<User> userOptional = userRepository.findByUsername(facebookDto.getUsername());
        User user = userOptional.get();
        TokenDto tokenDto = new TokenDto();
        SignInDto signInDto = SignInDto.builder()
                .username(facebookDto.getUsername())
                .password(facebookDto.getPassword())
                .build();
        tokenDto.setToken(jwtTokenProvider.createToken(signInDto, user));
        tokenDto.setRole(user.getRole().toString());
        return tokenDto;
    }
}

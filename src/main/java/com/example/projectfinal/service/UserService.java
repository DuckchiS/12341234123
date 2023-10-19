package com.example.projectfinal.service;

import com.example.projectfinal.exception.ErrorCode;
import com.example.projectfinal.exception.SimpleException;
import com.example.projectfinal.model.User;
import com.example.projectfinal.model.entity.UserEntity;
import com.example.projectfinal.repository.UserRepository;
import com.example.projectfinal.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName).map(User::fromEntity).orElseThrow(
                () -> new SimpleException(ErrorCode.USER_NOT_FOUND, String.format("userName is %s", userName))
        );
    }


    public String login(String userName, String password) {
        User savedUser = loadUserByUsername(userName);

        if (!encoder.matches(password, savedUser.getPassword())) {
            throw new SimpleException(ErrorCode.INVALID_PASSWORD, String.format("userName is %s", userName));
        }
        return JwtTokenUtils.generateAccessToken(userName, secretKey, expiredTimeMs);
    }


    @Transactional
    public User join(String userName, String password) {
        // check the userId not exist
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SimpleException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName is %s", userName));
        });

        UserEntity savedUser = userRepository.save(UserEntity.of(userName, encoder.encode(password)));
        return User.fromEntity(savedUser);
    }
}

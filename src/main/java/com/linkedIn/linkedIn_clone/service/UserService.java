package com.linkedIn.linkedIn_clone.service;



import com.linkedIn.linkedIn_clone.DTO.AuthResponse;
import com.linkedIn.linkedIn_clone.DTO.LoginRequest;
import com.linkedIn.linkedIn_clone.DTO.SignupRequest;
import com.linkedIn.linkedIn_clone.DTO.UserProfileResponse;
import com.linkedIn.linkedIn_clone.JwtService;

import com.linkedIn.linkedIn_clone.model.User;
import com.linkedIn.linkedIn_clone.repository.PostRepository;
import com.linkedIn.linkedIn_clone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  JwtService jwtService;

    @Autowired
    private PostRepository postRepository;

    public AuthResponse signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(savedUser.getEmail(), savedUser.getId());

        return new AuthResponse(token, savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail(), user.getId());

        return new AuthResponse(token, user.getId(), user.getName(), user.getEmail());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfileResponse getUserProfile(Long userId) {
        User user = getUserById(userId);
        int postCount = postRepository.findByUserIdOrderByCreatedAtDesc(userId).size();

        return new UserProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfileImage(),
                user.getCreatedAt(),
                postCount
        );
    }

    @Transactional
    public User updateProfileImage(Long userId, String imageUrl) {
        User user = getUserById(userId);
        user.setProfileImage(imageUrl);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUserProfile(Long userId, String name) {
        User user = getUserById(userId);
        if (name != null && !name.trim().isEmpty()) {
            user.setName(name.trim());
        }
        return userRepository.save(user);
    }
}

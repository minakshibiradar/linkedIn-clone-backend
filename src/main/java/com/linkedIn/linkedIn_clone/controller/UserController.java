package com.linkedIn.linkedIn_clone.controller;




import com.linkedIn.linkedIn_clone.DTO.UserProfileResponse;
import com.linkedIn.linkedIn_clone.model.User;
import com.linkedIn.linkedIn_clone.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    @PutMapping("/profile/image")
    public ResponseEntity<User> updateProfileImage(
            @RequestBody Map<String, String> body,
            HttpServletRequest request
    ) {
        Long userId = (Long) request.getAttribute("userId");
        String imageUrl = body.get("imageUrl");
        return ResponseEntity.ok(userService.updateProfileImage(userId, imageUrl));
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateProfile(
            @RequestBody Map<String, String> body,
            HttpServletRequest request
    ) {
        Long userId = (Long) request.getAttribute("userId");
        String name = body.get("name");
        return ResponseEntity.ok(userService.updateUserProfile(userId, name));
    }
}

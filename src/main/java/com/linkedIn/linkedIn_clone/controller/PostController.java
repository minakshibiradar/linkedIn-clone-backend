package com.linkedIn.linkedIn_clone.controller;


import com.linkedIn.linkedIn_clone.DTO.PostRequest;
import com.linkedIn.linkedIn_clone.DTO.PostResponse;
import com.linkedIn.linkedIn_clone.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private  PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @Valid @RequestBody PostRequest request,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(postService.createPost(request, userId));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(HttpServletRequest httpRequest) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(postService.getAllPosts(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(
            @PathVariable Long id,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(postService.getPostById(id, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody PostRequest request,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(postService.updatePost(id, request, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(
            @PathVariable Long id,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        postService.deletePost(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostResponse>> getUserPosts(
            @PathVariable Long userId,
            HttpServletRequest httpRequest
    ) {
        Long currentUserId = (Long) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(postService.getUserPosts(userId, currentUserId));
    }

    @PostMapping("/{id}/share")
    public ResponseEntity<PostResponse> sharePost(
            @PathVariable Long id,
            @RequestBody(required = false) Map<String, String> body,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        String additionalContent = body != null ? body.get("content") : null;
        return ResponseEntity.ok(postService.sharePost(id, additionalContent, userId));
    }
}

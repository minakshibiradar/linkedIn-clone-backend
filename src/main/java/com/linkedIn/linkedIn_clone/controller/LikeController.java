package com.linkedIn.linkedIn_clone.controller;



import com.linkedIn.linkedIn_clone.service.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/posts/{postId}/likes")
@RequiredArgsConstructor
public class LikeController {

    @Autowired
    private  LikeService likeService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> toggleLike(
            @PathVariable Long postId,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        boolean liked = likeService.toggleLike(postId, userId);

        Map<String, Object> response = new HashMap<>();
        response.put("liked", liked);
        response.put("likeCount", likeService.getLikeCount(postId));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Boolean>> getLikeStatus(
            @PathVariable Long postId,
            HttpServletRequest httpRequest
    ) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        boolean liked = likeService.isLikedByUser(postId, userId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("liked", liked);

        return ResponseEntity.ok(response);
    }
}

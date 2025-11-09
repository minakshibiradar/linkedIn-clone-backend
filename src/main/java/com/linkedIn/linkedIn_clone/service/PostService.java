package com.linkedIn.linkedIn_clone.service;


import com.linkedIn.linkedIn_clone.DTO.PostRequest;
import com.linkedIn.linkedIn_clone.DTO.PostResponse;
import com.linkedIn.linkedIn_clone.model.Post;
import com.linkedIn.linkedIn_clone.model.User;
import com.linkedIn.linkedIn_clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {


    @Autowired
    private  PostRepository postRepository;
    @Autowired
    private  UserService userService;
    @Autowired
    private  LikeService likeService;

    @Transactional
    public PostResponse createPost(PostRequest request, Long userId) {
        User user = userService.getUserById(userId);

        Post post = new Post();
        post.setContent(request.getContent());
        post.setImageUrl(request.getImageUrl());
        post.setUser(user);

        Post savedPost = postRepository.save(post);

        return mapToResponse(savedPost, userId);
    }

    public List<PostResponse> getAllPosts(Long currentUserId) {
        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(post -> mapToResponse(post, currentUserId))
                .collect(Collectors.toList());
    }

    public PostResponse getPostById(Long id, Long currentUserId) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return mapToResponse(post, currentUserId);
    }

    @Transactional
    public PostResponse updatePost(Long postId, PostRequest request, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized to update this post");
        }

        post.setContent(request.getContent());
        post.setImageUrl(request.getImageUrl());
        post.setUpdatedAt(LocalDateTime.now());

        Post updatedPost = postRepository.save(post);
        return mapToResponse(updatedPost, userId);
    }

    @Transactional
    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized to delete this post");
        }

        postRepository.delete(post);
    }

    public List<PostResponse> getUserPosts(Long userId, Long currentUserId) {
        return postRepository.findByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(post -> mapToResponse(post, currentUserId))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostResponse sharePost(Long postId, String additionalContent, Long userId) {
        Post originalPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userService.getUserById(userId);

        Post sharedPost = new Post();
        sharedPost.setContent(additionalContent != null ? additionalContent : "");
        sharedPost.setUser(user);
        sharedPost.setSharedPost(originalPost);

        Post savedPost = postRepository.save(sharedPost);

        // Update share count
        originalPost.setShareCount(originalPost.getShareCount() + 1);
        postRepository.save(originalPost);

        return mapToResponse(savedPost, userId);
    }

    private PostResponse mapToResponse(Post post, Long currentUserId) {
        boolean likedByCurrentUser = likeService.isLikedByUser(post.getId(), currentUserId);

        PostResponse sharedPostResponse = null;
        if (post.getSharedPost() != null) {
            Post shared = post.getSharedPost();
            sharedPostResponse = new PostResponse(
                    shared.getId(),
                    shared.getContent(),
                    shared.getImageUrl(),
                    shared.getCreatedAt(),
                    shared.getUser().getId(),
                    shared.getUser().getName(),
                    shared.getUser().getProfileImage(),
                    shared.getLikeCount(),
                    shared.getCommentCount(),
                    shared.getShareCount(),
                    likeService.isLikedByUser(shared.getId(), currentUserId),
                    null,
                    null
            );
        }

        return new PostResponse(
                post.getId(),
                post.getContent(),
                post.getImageUrl(),
                post.getCreatedAt(),
                post.getUser().getId(),
                post.getUser().getName(),
                post.getUser().getProfileImage(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getShareCount(),
                likedByCurrentUser,
                post.getSharedPost() != null ? post.getSharedPost().getId() : null,
                sharedPostResponse
        );
    }
}

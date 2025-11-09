package com.linkedIn.linkedIn_clone.service;


import com.linkedIn.linkedIn_clone.model.Like;
import com.linkedIn.linkedIn_clone.model.Post;
import com.linkedIn.linkedIn_clone.model.User;
import com.linkedIn.linkedIn_clone.repository.LikeRepository;
import com.linkedIn.linkedIn_clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    @Autowired
    private  LikeRepository likeRepository;
    @Autowired
    private  PostRepository postRepository;
    @Autowired
    private  UserService userService;

    @Transactional
    public boolean toggleLike(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userService.getUserById(userId);

        // Check if already liked
        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            // Unlike
            likeRepository.deleteByUserIdAndPostId(userId, postId);
            post.setLikeCount(Math.max(0, post.getLikeCount() - 1));
            postRepository.save(post);
            return false; // unliked
        } else {
            // Like
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            likeRepository.save(like);

            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
            return true; // liked
        }
    }

    public boolean isLikedByUser(Long postId, Long userId) {
        return likeRepository.existsByUserIdAndPostId(userId, postId);
    }

    public int getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}

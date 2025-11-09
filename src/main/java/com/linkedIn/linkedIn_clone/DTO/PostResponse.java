package com.linkedIn.linkedIn_clone.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data

public class PostResponse {
    private Long id;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;
    private Long userId;
    private String userName;
    private String userProfileImage;
    private int likeCount;
    private int commentCount;
    private int shareCount;
    private boolean likedByCurrentUser;

    private Long sharedPostId;
    private PostResponse sharedPost;

    public PostResponse() {
    }

    public PostResponse(Long id, String content, String imageUrl, LocalDateTime createdAt, Long userId, String userName, String userProfileImage, int likeCount, int commentCount, int shareCount, boolean likedByCurrentUser, Long sharedPostId, PostResponse sharedPost) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.userId = userId;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
        this.likedByCurrentUser = likedByCurrentUser;
        this.sharedPostId = sharedPostId;
        this.sharedPost = sharedPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public boolean isLikedByCurrentUser() {
        return likedByCurrentUser;
    }

    public void setLikedByCurrentUser(boolean likedByCurrentUser) {
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public Long getSharedPostId() {
        return sharedPostId;
    }

    public void setSharedPostId(Long sharedPostId) {
        this.sharedPostId = sharedPostId;
    }

    public PostResponse getSharedPost() {
        return sharedPost;
    }

    public void setSharedPost(PostResponse sharedPost) {
        this.sharedPost = sharedPost;
    }
}

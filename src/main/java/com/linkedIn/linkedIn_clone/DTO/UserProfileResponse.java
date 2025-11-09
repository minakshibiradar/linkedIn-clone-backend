package com.linkedIn.linkedIn_clone.DTO;




import lombok.Data;
import java.time.LocalDateTime;

@Data

public class UserProfileResponse {
    private Long id;
    private String name;
    private String email;
    private String profileImage;
    private LocalDateTime createdAt;
    private int postCount;

    public UserProfileResponse() {
    }

    public UserProfileResponse(Long id, String name, String email, String profileImage, LocalDateTime createdAt, int postCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
        this.createdAt = createdAt;
        this.postCount = postCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }
}

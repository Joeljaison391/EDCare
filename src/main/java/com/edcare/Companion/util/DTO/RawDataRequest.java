package com.edcare.Companion.util.DTO;

public class RawDataRequest {

    private String userProfileId;
    private String content;

    // Getters and setters
    public String getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = String.valueOf(userProfileId);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
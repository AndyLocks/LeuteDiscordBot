package org.leuteds.model;

public class DiscordAccountPost {
    public DiscordAccountPost() {}
    public String nickname;
    public String name;
    public String description;
    public String userId;
    public String imageUrl;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DiscordAccountPost(String nickname, String name, String description, String userId, String imageUrl) {
        this.nickname = nickname;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.imageUrl = imageUrl;
    }
}

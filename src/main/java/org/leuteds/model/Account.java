package org.leuteds.model;

public class Account {
    public Account() {}

    /*
    {
  "nickname": "aboba",
  "realName": "string",
  "description": "string",
  "discord_user_id": "90324892384",
  "image_url": "https://google.com",
  "discord_nickname": "andylocks",
  "discord_description": "pp",
  "email": "aboba.sperma@zalupa.org",
  "discordName": "Andy Locks"
}
     */
    private String nickname;
    private String realName;
    private String description;
    private String discord_user_id;
    private String image_url;
    private String discord_nickname;
    private String discord_description;
    private String email;
    private String discordName;

    public Account(String nickname, String realName, String description,
                   String discord_user_id, String image_url, String discord_nickname,
                   String discord_description, String email, String discordName) {
        this.nickname = nickname;
        this.realName = realName;
        this.description = description;
        this.discord_user_id = discord_user_id;
        this.image_url = image_url;
        this.discord_nickname = discord_nickname;
        this.discord_description = discord_description;
        this.email = email;
        this.discordName = discordName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public String getDiscordUserId() {
        return discord_user_id;
    }

    public void setDiscordUserId(String discord_user_id) {
        this.discord_user_id = discord_user_id;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getDiscordNickname() {
        return discord_nickname;
    }

    public void setDiscordNickname(String discord_nickname) {
        this.discord_nickname = discord_nickname;
    }

    public String getDiscordDescription() {
        return discord_description;
    }

    public void setDiscordDescription(String discord_description) {
        this.discord_description = discord_description;
    }




    private String getDiscord_user_id() {
        return discord_user_id;
    }

    private void setDiscord_user_id(String discord_user_id) {
        this.discord_user_id = discord_user_id;
    }

    private String getImage_url() {
        return image_url;
    }

    private void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    private String getDiscord_nickname() {
        return discord_nickname;
    }

    private void setDiscord_nickname(String discord_nickname) {
        this.discord_nickname = discord_nickname;
    }

    private String getDiscord_description() {
        return discord_description;
    }

    private void setDiscord_description(String discord_description) {
        this.discord_description = discord_description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscordName() {
        return discordName;
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", description='" + description + '\'' +
                ", discord_user_id='" + discord_user_id + '\'' +
                ", image_url='" + image_url + '\'' +
                ", discord_nickname='" + discord_nickname + '\'' +
                ", discord_description='" + discord_description + '\'' +
                ", email='" + email + '\'' +
                ", discordName='" + discordName + '\'' +
                '}';
    }
}

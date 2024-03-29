package org.leuteds.model;

public class AccountRegistrationPost {
    /*
    {
      "nickname": "string",
      "realName": "string",
      "description": "string",
      "email": "string",
      "password": "string"
    }
     */

    public AccountRegistrationPost() {}
    private String nickname;
    private String realName;
    private String description;
    private String email;
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRegistrationPost(String nickname, String realName, String description, String email, String password) {
        this.nickname = nickname;
        this.realName = realName;
        this.description = description;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountRegistrationPost{" +
                "nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

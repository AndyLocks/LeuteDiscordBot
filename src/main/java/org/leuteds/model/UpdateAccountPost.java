package org.leuteds.model;

public class UpdateAccountPost {
    public UpdateAccountPost() {}
    private String description;
    private String realName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UpdateAccountPost(String description, String realName) {
        this.description = description;
        this.realName = realName;
    }
}

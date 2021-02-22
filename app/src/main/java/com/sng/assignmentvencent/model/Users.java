package com.sng.assignmentvencent.model;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("avatar")
    String avatar;
    @SerializedName("email")
    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

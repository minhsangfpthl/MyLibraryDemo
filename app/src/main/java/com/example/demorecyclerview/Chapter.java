package com.example.demorecyclerview;

public class Chapter {
    private int avatar_id;
    private String title;
    private String description;

    public Chapter(int avatar_id, String title, String description) {
        this.avatar_id = avatar_id;
        this.title = title;
        this.description = description;
    }

    public int getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(int avatar_id) {
        this.avatar_id = avatar_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

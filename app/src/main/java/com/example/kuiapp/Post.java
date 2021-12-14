package com.example.kuiapp;

public class Post {
    private String title;
    private String description;
    private String ownerName;

    public Post(){

    }

    public Post(String title, String description, String ownerName) {
        this.title = title;
        this.description = description;
        this.ownerName = ownerName;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

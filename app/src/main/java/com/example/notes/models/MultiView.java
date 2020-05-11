package com.example.notes.models;

public class MultiView {
    public static final int left=0;
    public static final int Right=1;
    String name;
    String description;
    int type;
    int image;

    public MultiView(String name, String description, int image,int type) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.type=type;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

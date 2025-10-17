package com.example.facebook;

public class Story {
    private int imageRes;
    private String name;
    private boolean isCreateStory;

    public Story(int imageRes, String name, boolean isCreateStory) {
        this.imageRes = imageRes;
        this.name = name;
        this.isCreateStory = isCreateStory;
    }

    public Story(int imageRes, String name) {
        this(imageRes, name, false);
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }

    public boolean isCreateStory() {
        return isCreateStory;
    }
}

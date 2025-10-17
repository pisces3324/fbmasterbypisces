package com.example.facebook;

public class Post {
    private int userAvatar;
    private String userName;
    private String content;
    private int postImage;

    public Post(int userAvatar, String userName, String content, int postImage) {
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.content = content;
        this.postImage = postImage;
    }

    public int getUserAvatar() { return userAvatar; }
    public String getUserName() { return userName; }
    public String getContent() { return content; }
    public int getPostImage() { return postImage; }
}

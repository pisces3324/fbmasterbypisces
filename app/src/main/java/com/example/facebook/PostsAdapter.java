package com.example.facebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> posts;

    public PostsAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView userAvatar, postImage;
        TextView userName, content;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.postUserAvatar);
            userName = itemView.findViewById(R.id.postUserName);
            content = itemView.findViewById(R.id.postContent);
            postImage = itemView.findViewById(R.id.postImage);
        }
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.userAvatar.setImageResource(post.getUserAvatar());
        holder.userName.setText(post.getUserName());
        holder.content.setText(post.getContent());
        holder.postImage.setImageResource(post.getPostImage());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}

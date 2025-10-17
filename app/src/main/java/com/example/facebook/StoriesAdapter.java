package com.example.facebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoryViewHolder> {

    private List<Story> stories;
    private Context context;

    public StoriesAdapter(List<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_story, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story story = stories.get(position);

        holder.storyName.setText(story.getName());
        holder.storyImage.setImageResource(story.getImageRes());

        if (story.isCreateStory()) {
            holder.plusIcon.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, CreateStoryActivity.class);
                context.startActivity(intent);
            });
        } else {
            holder.plusIcon.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, StoryDetailActivity.class);
                intent.putExtra("storyName", story.getName());
                intent.putExtra("storyImage", story.getImageRes());
                intent.putExtra("storyTime", "5 giờ");
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImage;
        ImageView plusIcon;
        TextView storyName;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = itemView.findViewById(R.id.storyImage);
            plusIcon = itemView.findViewById(R.id.plusIcon);
            storyName = itemView.findViewById(R.id.storyUser);
        }
    }
}

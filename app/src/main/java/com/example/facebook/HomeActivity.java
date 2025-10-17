package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView more, search, message;
    private BottomNavigationView bottomNavigationView;

    private RecyclerView storiesRecyclerView, postsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupHeaderClicks();
        setupBottomNavigation();
        setupStories();
        setupPosts();
    }

    private void initViews() {
        textView = findViewById(R.id.textView);
        more = findViewById(R.id.more);
        search = findViewById(R.id.search);
        message = findViewById(R.id.message);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        storiesRecyclerView = findViewById(R.id.storiesRecyclerView);
        postsRecyclerView = findViewById(R.id.postsRecyclerView);
    }

    private void setupHeaderClicks() {
        search.setOnClickListener(v -> startActivity(new Intent(this, SearchActivity.class)));
        message.setOnClickListener(v -> startActivity(new Intent(this, MessengersActivity.class)));

        more.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(HomeActivity.this, more);
            popupMenu.getMenuInflater().inflate(R.menu.post_options_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.action_post) {
                    startActivity(new Intent(this, CreatePostActivity.class));
                } else if (id == R.id.action_news) {
                    startActivity(new Intent(this, CreateStoryActivity.class));
                } else if (id == R.id.action_film) {
                    startActivity(new Intent(this, CreateFilmActivity.class));
                } else if (id == R.id.action_live) {
                    startActivity(new Intent(this, LiveStreamActivity.class));
                } else if (id == R.id.action_note) {
                    startActivity(new Intent(this, CreateNoteActivity.class));
                } else if (id == R.id.action_ai) {
                    startActivity(new Intent(this, GeminiActivity.class));
                }
                return true;
            });
            popupMenu.show();
        });
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) return true;
            else if (id == R.id.nav_friends) startActivity(new Intent(this, FriendsActivity.class));
            else if (id == R.id.nav_watch) startActivity(new Intent(this, VideoActivity.class));
            else if (id == R.id.nav_notifications) startActivity(new Intent(this, NotificationsActivity.class));
            else if (id == R.id.nav_menu) startActivity(new Intent(this, MenuActivity.class));
            return false;
        });
    }

    private void setupStories() {
        List<Story> stories = new ArrayList<>();
        stories.add(new Story(R.drawable.img1, "Tạo tin", true));
        stories.add(new Story(R.drawable.img2, "Nguyễn Văn A", false));
        stories.add(new Story(R.drawable.img3, "Nguyễn Văn B", false));
        stories.add(new Story(R.drawable.img6, "Nguyễn Văn C", false));

        StoriesAdapter storiesAdapter = new StoriesAdapter(stories, this); // truyền context để xử lý click
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        storiesRecyclerView.setLayoutManager(layoutManager);
        storiesRecyclerView.setAdapter(storiesAdapter);
    }

    private void setupPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.img3, "Nguyễn Văn A", "Buổi chiều vui vẻ!", R.drawable.img17));
        posts.add(new Post(R.drawable.img9, "Nguyễn Văn B", "Ăn trưa ngon quá!", R.drawable.img4));
        posts.add(new Post(R.drawable.img20, "Nguyễn Văn C", "Chơi thể thao cuối tuần", R.drawable.img22));

        PostsAdapter postsAdapter = new PostsAdapter(posts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        postsRecyclerView.setLayoutManager(layoutManager);
        postsRecyclerView.setAdapter(postsAdapter);
    }
}

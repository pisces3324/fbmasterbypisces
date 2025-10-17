package com.example.facebook;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CommentActivity extends AppCompatActivity {

    private EditText comment;
    private ImageView sendComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        comment = findViewById(R.id.comment);
        sendComment = findViewById(R.id.send_comment);


        sendComment.setOnClickListener(v -> {
            String text = comment.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập bình luận!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đã comment: " + text, Toast.LENGTH_SHORT).show();

                comment.setText("");
            }
        });
    }
}

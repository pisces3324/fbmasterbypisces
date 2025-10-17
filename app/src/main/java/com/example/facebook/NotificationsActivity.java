package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    private ImageView imgOption1, imgOption2;
    private LinearLayout layoutNotif1, layoutNotif2, layoutNotif3, layoutNotif4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);


        imgOption1 = findViewById(R.id.imgOption1);
        imgOption2 = findViewById(R.id.imgOption2);

        imgOption1.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Tùy chọn thông báo", Toast.LENGTH_SHORT).show());

        imgOption2.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Tìm kiếm thông báo", Toast.LENGTH_SHORT).show());

        layoutNotif1 = findViewById(R.id.layoutNotif1);
        layoutNotif2 = findViewById(R.id.layoutNotif2);
        layoutNotif3 = findViewById(R.id.layoutNotif3);
        layoutNotif4 = findViewById(R.id.layoutNotif4);

        layoutNotif1.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Mở thông báo: Nguyen thi thuy", Toast.LENGTH_SHORT).show());

        layoutNotif2.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Mở thông báo: Nguyen van anh", Toast.LENGTH_SHORT).show());

        layoutNotif3.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Mở thông báo: giang a pao", Toast.LENGTH_SHORT).show());

        layoutNotif4.setOnClickListener(v ->
                Toast.makeText(NotificationsActivity.this, "Mở thông báo: giang a su", Toast.LENGTH_SHORT).show());
    }
}

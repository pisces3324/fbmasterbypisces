package com.example.facebook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GeminiActivity extends AppCompatActivity {

    private static final String API_KEY = "YOUR_GEMINI_API_KEY_HERE";
    private static final String API_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + API_KEY;

    EditText inputText;
    Button btnSend;
    TextView outputText;

    OkHttpClient client = new OkHttpClient();
    MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemini);

        inputText = findViewById(R.id.inputText);
        btnSend = findViewById(R.id.btnSend);
        outputText = findViewById(R.id.outputText);

        btnSend.setOnClickListener(v -> {
            String prompt = inputText.getText().toString();
            if (!prompt.isEmpty()) {
                new Thread(() -> callGeminiAPI(prompt)).start();
            }
        });
    }

    private void callGeminiAPI(String prompt) {
        try {
            JSONObject content = new JSONObject()
                    .put("contents", new JSONArray()
                            .put(new JSONObject()
                                    .put("parts", new JSONArray()
                                            .put(new JSONObject().put("text", prompt)))));

            RequestBody body = RequestBody.create(content.toString(), JSON);

            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();

                    JSONObject obj = new JSONObject(jsonResponse);
                    String text = obj.getJSONArray("candidates")
                            .getJSONObject(0)
                            .getJSONObject("content")
                            .getJSONArray("parts")
                            .getJSONObject(0)
                            .getString("text");

                    runOnUiThread(() -> outputText.setText(text));
                } else {
                    runOnUiThread(() -> outputText.setText("Lỗi: " + response.message()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            runOnUiThread(() -> outputText.setText("Lỗi kết nối: " + e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(() -> outputText.setText("Lỗi xử lý: " + e.getMessage()));
        }
    }
}

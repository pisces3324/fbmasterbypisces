package com.example.facebook;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
    public boolean insertUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        long result = db.insert("users", null, values);
        db.close();
        return result != -1;
    }
    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }
    public boolean checkUserByEmail(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email=? AND password=?", new String[]{email, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }
public boolean checkUserByEmailExist(String email) {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email=?", new String[]{email});
    boolean exists = cursor.getCount() > 0;
    cursor.close();
    db.close();
    return exists;
}
public boolean updatePasswordByEmail(String email, String newPassword) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put("password", newPassword);
    int updated = db.update("users", cv, "email=?", new String[]{email});
    db.close();
    return updated > 0;
}
}
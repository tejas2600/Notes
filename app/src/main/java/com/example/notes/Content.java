package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Content extends AppCompatActivity {
    EditText editText_title;
    EditText editText_content;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        editText_title=findViewById(R.id.content_title);
        editText_content=findViewById(R.id.content);
        String title=getIntent().getStringExtra("title");
        String content=getIntent().getStringExtra("content");
        id=getIntent().getIntExtra("id",0);
        editText_title.setText(title);
        editText_content.setText(content);
    }
    protected void onPause() {

        super.onPause();
        MainActivity.noteDatabase.NoteDao().save(editText_title.getText().toString(),editText_content.getText().toString(),id);
    }
}

package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton button;
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;
    RecyclerView.LayoutManager layoutManager;
    static NoteDatabase noteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDatabase= Room.databaseBuilder(getApplicationContext(),NoteDatabase.class,"notes").allowMainThreadQueries().build();

        recyclerView=findViewById(R.id.recyler_view);
        layoutManager=new LinearLayoutManager(this);
        noteAdapter=new NoteAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(noteAdapter);

         button=findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteDatabase.NoteDao().create();
                noteAdapter.reload();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.reload();
    }
}

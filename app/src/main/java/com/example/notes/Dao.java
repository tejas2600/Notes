package com.example.notes;

import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("INSERT INTO notes(title,content) VALUES ('New Title','New Note')")
    void create() ;

    @Query("SELECT * FROM Notes")
    List<Note> getAllNotes();

    @Query("UPDATE notes SET title= :title , content= :content WHERE id= :id")
    void save(String title,String content,int id);
}

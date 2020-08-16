package com.example.notes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new NoteViewHolder(view);
    }
    List<Note> arrayList_notes=new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note current=arrayList_notes.get(position);
        holder.title.setText(current.title);
        holder.containview.setTag(current);

    }

    @Override
    public int getItemCount() {
        return arrayList_notes.size();
    }

    void reload(){
        arrayList_notes=MainActivity.noteDatabase.NoteDao().getAllNotes();
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        LinearLayout containview;
        TextView title;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            containview=itemView.findViewById(R.id.container_view);
            title=itemView.findViewById(R.id.title);


            containview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note current=(Note) containview.getTag();
                  Intent intent=new Intent(v.getContext(),Content.class);
                  intent.putExtra("id",current.id);
                  intent.putExtra("title",current.title);
                  intent.putExtra("content",current.content);
                  v.getContext().startActivity(intent);
                }
            });
        }


    }
}

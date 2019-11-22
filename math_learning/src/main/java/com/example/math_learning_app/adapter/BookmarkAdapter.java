package com.example.math_learning_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.BookmarkViewHolder;
import com.example.math_learning_app.R;
import com.example.math_learning_app.YouTubeActivity;
import com.example.math_learning_app.model.Topic;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {

    Context context;
    ArrayList<Topic> bookmarkedTopics;

    public BookmarkAdapter(ArrayList<Topic> bookmarkedTopics) {
        this.bookmarkedTopics = bookmarkedTopics;
    }

    @Override
    public BookmarkViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic, parent, false);
        this.context = parent.getContext();
        BookmarkViewHolder bookmarkViewHolder = new BookmarkViewHolder(view);
        return bookmarkViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, final int position){
        final Topic topicAtPosition = bookmarkedTopics.get(position);
        System.out.println("Bookmarked list: "  +topicAtPosition.getTitle()+" "+ topicAtPosition.getId());


        holder.topicTitle.setText(topicAtPosition.getTitle());
        holder.bookmarkLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), YouTubeActivity.class);
                System.out.println(topicAtPosition.getId());
                intent.putExtra("youtube_id",topicAtPosition.getId());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount(){
        return bookmarkedTopics.size();
    }

    public void setData(ArrayList<Topic> newBookmarkTopics) {
        this.bookmarkedTopics = newBookmarkTopics;
    }

}

package com.example.math_learning_app;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BookmarkViewHolder extends RecyclerView.ViewHolder {
    public TextView topicTitle;
    public LinearLayout bookmarkLinear;


    public BookmarkViewHolder(View view){
        super(view);
        topicTitle =view.findViewById(R.id.topicTitle);
        bookmarkLinear = view.findViewById(R.id.bookmarkLinear);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + topicTitle.getText() + "'";
    }

}

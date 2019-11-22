package com.example.math_learning_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.R;
import com.example.math_learning_app.YouTubeActivity;
import com.example.math_learning_app.activities.TopicDetailActivity;
import com.example.math_learning_app.model.Topic;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private List<Topic> topicsToAdapt;

    public void setData(List<Topic> topicsToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.topicsToAdapt = topicsToAdapt;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.topic, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        TopicViewHolder topicViewHolder = new TopicViewHolder(view);
        return topicViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        final Topic topicAtPosition = topicsToAdapt.get(position);

        holder.topicTitleTextView.setText(topicAtPosition.getTitle());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, YouTubeActivity.class);
                intent.putExtra("youtube_id", topicAtPosition.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return topicsToAdapt.size();
    }


    public static class TopicViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView topicTitleTextView;

        public TopicViewHolder(View v) {
            super(v);
            view = v;
            topicTitleTextView = v.findViewById(R.id.topicTitle);


        }
    }
}

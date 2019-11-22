package com.example.math_learning_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.R;
import com.example.math_learning_app.TopicQuiz;
import com.example.math_learning_app.YouTubeActivity;
import com.example.math_learning_app.model.Quiz;
import com.example.math_learning_app.model.Topic;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    private List<Quiz> quizzesToAdapt;

    public void setData(List<Quiz> quizzesToAdapt) {
        this.quizzesToAdapt = quizzesToAdapt;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.quiz, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        QuizViewHolder quizViewHolder = new QuizViewHolder(view);
        return quizViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        final Quiz quizAtPosition = quizzesToAdapt.get(position);

        holder.quizTitleBtn.setText(quizAtPosition.getLanguage());
        holder.quizTitleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, TopicQuiz.class);
                intent.putExtra("language", quizAtPosition.getLanguage());
                context.startActivity(intent);
            }
        });

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, TopicQuiz.class);
                intent.putExtra("language", quizAtPosition.getLanguage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quizzesToAdapt.size();
    }
    public static class QuizViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public Button quizTitleBtn;

        public QuizViewHolder(View v) {
            super(v);
            view = v;
            quizTitleBtn = v.findViewById(R.id.languageButton);


        }
    }
}

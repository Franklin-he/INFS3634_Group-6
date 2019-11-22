package com.example.math_learning_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.R;
import com.example.math_learning_app.adapter.QuizAdapter;
import com.example.math_learning_app.adapter.TopicAdapter;
import com.example.math_learning_app.model.Quiz;
import com.example.math_learning_app.model.Topic;

import java.util.ArrayList;

public class QuizRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;

    public QuizRecyclerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        QuizAdapter quizAdapter = new QuizAdapter();

        ArrayList<Quiz> results = new ArrayList<Quiz>() {
            {
                add(new Quiz(
                        "0",
                        "chinese"
                ));
                add(new Quiz(
                        "1",
                        "japanese"
                ));
                add(new Quiz(
                        "2",
                        "korean"

                ));

            }
        };

        quizAdapter.setData(results);
        recyclerView.setAdapter(quizAdapter);


        return view;


    }

}

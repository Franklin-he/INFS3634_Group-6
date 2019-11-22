package com.example.math_learning_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.R;
import com.example.math_learning_app.adapter.TopicAdapter;
import com.example.math_learning_app.model.Topic;

import java.util.ArrayList;

public class TopicsRecyclerFragment extends Fragment {

    public TopicsRecyclerFragment(){

    }
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TopicAdapter topicAdapter = new TopicAdapter();

        ArrayList<Topic> results = new ArrayList<Topic>() {
            {
                add(new Topic(
                        "0",
                        "Learn Chinese in 30 Minutes",
                        "QOpQf3fi2N4"
                ));
                add(new Topic(
                        "1",
                        "Learn the Top 25 Japanese Phrases!",
                        "n6ciMT6KhVo"));
                add(new Topic(
                        "2",
                        "Learn Korean in 20 Minutes",
                        "ZinAK6n6cWU"));



            }
        };

        topicAdapter.setData(results);
        recyclerView.setAdapter(topicAdapter);

        return view;


    }


}

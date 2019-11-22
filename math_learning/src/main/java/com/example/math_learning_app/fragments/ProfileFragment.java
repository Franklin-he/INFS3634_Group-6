package com.example.math_learning_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.math_learning_app.BookmarkDatabase;
import com.example.math_learning_app.R;
import com.example.math_learning_app.adapter.BookmarkAdapter;

public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BookmarkAdapter bookmarkAdapter;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerView = view.findViewById(R.id.bookmarkRecycler);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        bookmarkAdapter = new BookmarkAdapter(BookmarkDatabase.getBookmarkedTopics());
        recyclerView.setAdapter(bookmarkAdapter);


        return view;

    }

}

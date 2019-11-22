package com.example.math_learning_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.math_learning_app.R;
import com.example.math_learning_app.fragments.ProfileFragment;
import com.example.math_learning_app.fragments.QuizRecyclerFragment;
import com.example.math_learning_app.fragments.TopicsRecyclerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new TopicsRecyclerFragment();
        swapFragment(fragment);
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the menu of the BottomnNavigationView
                // The menu is chunked out as bottom_nav_menu.xml in the res > menu folder
                if (menuItem.getItemId() == R.id.nav_topics) {
                    Fragment fragment = new TopicsRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_quizzes) {
                    Fragment fragment = new QuizRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_profile) {
                    Fragment fragment = new ProfileFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });

    }
    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }
}

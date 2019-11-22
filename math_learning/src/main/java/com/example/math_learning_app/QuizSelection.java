package com.example.math_learning_app;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class QuizSelection extends Activity {
    //code for putting a video in the background: https://www.youtube.com/watch?v=tPeDn18FrGY&feature=youtu.be

    //Declaring the video view and button in the UI
    VideoView videoView;
    Button homeButton;
    Button chineseBtn, japBtn, korBtn;
    TextView selectTextView;
    TextView selectTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);

        //Linking the video view to the one in the UI
        videoView = findViewById(R.id.videoView);

        //Defining the location of the video
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bd_vid);

        //Setting the location for the video
        videoView.setVideoURI(uri);

        //Starting the video
        videoView.start();

        //Setting the loop for the video so it would repeat
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        //Linking the text views to the ones in the UI
        selectTextView = findViewById(R.id.header);
        selectTextView2 = findViewById(R.id.header2);

        //Linking the button to the one in the UI
        homeButton = findViewById(R.id.home_button);

        //set an on-click listener so it would go to the main screen when clicked
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSelection.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Linking the buttons to the UI
        chineseBtn = findViewById(R.id.chinese);
        japBtn = findViewById(R.id.japanese);
        korBtn = findViewById(R.id.korean);

        //Setting an on-click listener to lead the user to the quiz questions for
        // the topic through the use of intent
        chineseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSelection.this,TopicQuiz.class);
                //sending the name of the topic through intent to show the
                //corresponding questions
                intent.putExtra("language","chinese");
                startActivity(intent);

            }
        });

        japBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSelection.this,TopicQuiz.class);
                //sending the name of the topic through intent to show the
                //corresponding questions
                intent.putExtra("language","japanese");
                startActivity(intent);

            }
        });

        korBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSelection.this,TopicQuiz.class);
                //sending the name of the topic through intent to show the
                //corresponding questions
                intent.putExtra("language","korean");
                startActivity(intent);

            }
        });
    }


}

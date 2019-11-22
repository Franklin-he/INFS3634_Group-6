package com.example.math_learning_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TopicQuiz extends Activity {

    //Declaring the components to link to the UI
    TextView questionTextView;
    Button trueButton;
    Button falseButton;

    //Defining the Questions array to store the questions
    Questions[] question = new Questions[30];

    //To keep track of which question is being asked
    int quesNumber = 0;

    String topic;

    String TAG = "TopicQuiz";

    //To count the number of questions the user got right
    int rightQuesCounter = 0;

    //To count how many questions have been asked
    int quesCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_quiz);

        //Linking the components to the UI
        questionTextView = findViewById(R.id.quesTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        //Constructing the question objects with actual parameters
        //set of questions for sqlite
        question[0] = new Questions(R.string.question1, true, "True");
        question[1] = new Questions(R.string.question2, false, "False");
        question[2] = new Questions(R.string.question3, true, "True");
        question[3] = new Questions(R.string.question4, false,"False");

        question[4] = new Questions(R.string.question5, true, "True");
        question[5] = new Questions(R.string.question6, false,"False");
        question[6] = new Questions(R.string.question7, true, "True");
        question[7] = new Questions(R.string.question8, false, "True");

        question[8] = new Questions(R.string.question9, true, "True");
        question[9] = new Questions(R.string.question10, false, "False");
        question[10] = new Questions(R.string.question11, true, "False");
        question[11] = new Questions(R.string.question12, true, "False");


        //Retrieving the intent sent
        Intent intent = getIntent();

        //Defining the "topic" object with the "topic_name" delivered by the intent
        topic = intent.getStringExtra("language");
        final int maxQuestions;
        //checking to see if the method getStringExtra worked or not, to see if topic is null.
        Log.d(TAG, "The name of the topic is: " + topic);

        //Setting the textView to the first question of the corresponding topic
        //Setting quesNumber to the corresponding first question number of the topic being asked
        if (topic.equals("chinese")) {
            questionTextView.setText(question[0].getQuesStatement());
            quesNumber = 0;

        } else if (topic.equals("japanese")) {
            questionTextView.setText(question[4].getQuesStatement());
            quesNumber = 4;

        } else {
            questionTextView.setText(question[7].getQuesStatement());
            quesNumber = 7;

        }




        //setting an OnClickListener for the buttons to return a feedback on the user's answer and
        //move to the next question
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //increment the counter to get the quiz to stop moving to the next question if it's
                //the last on already
                quesCounter++;
                if (quesCounter < 4) {
                    //returning a feedback saying "correct answer" if the user has chosen the correct answer and
                    //"incorrect answer" otherwise
                    if (question[quesNumber].isAnsTrue()) {
                        Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        rightQuesCounter++;
                    } else {
                        Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                        question[quesNumber].setWrong(true);
                    }

                    //incrementing quesNumber to move to the next question
                    quesNumber++;
                    questionTextView.setText(question[quesNumber].getQuesStatement());

                } else {
                    if (question[quesNumber].isAnsTrue()) {
                        Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        rightQuesCounter++;
                    } else {
                        Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();

                    }
                    //Checking to see if the rightQuesCounter worked or not
                    Log.d(TAG, "You have got " + rightQuesCounter + " out of 10");

                    //Having an intent to move to the Result screen while passing the rightQuesCounter to get the result
                    Intent intent = new Intent(TopicQuiz.this, Result.class);
                    intent.putExtra("rightQuesCounter", rightQuesCounter);

                    startActivity(intent);
                }

            }

        });

        falseButton.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {
                                               //increment the counter to get the quiz to stop moving to the next question if it's
                                               //the last on already
                                               quesCounter++;
                                               if (quesCounter < 4) {
                                                   //returning a feedback saying "correct answer" if the user has chosen the correct answer and
                                                   //"incorrect answer" otherwise
                                                   if (question[quesNumber].isAnsTrue()) {
                                                       Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();


                                                   } else {
                                                       Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                       rightQuesCounter++;
                                                   }
                                                   //incrementing quesNumber to move to the next question
                                                   quesNumber++;
                                                   questionTextView.setText(question[quesNumber].getQuesStatement());
                                               } else {
                                                   if (question[quesNumber].isAnsTrue()) {
                                                       Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();


                                                   } else {
                                                       Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                       rightQuesCounter++;
                                                   }

                                                   //Checking to see if the rightQuesCounter worked or not
                                                   Log.d(TAG, "You have got " + rightQuesCounter + " questions right!");

                                                   //Having an intent to move to the Result screen while passing the rightQuesCounter to get the result
                                                   Intent intent = new Intent(TopicQuiz.this, Result.class);
                                                   intent.putExtra("rightQuesCounter", rightQuesCounter);
                                                   intent.putExtra("language",topic);


                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
    }

}

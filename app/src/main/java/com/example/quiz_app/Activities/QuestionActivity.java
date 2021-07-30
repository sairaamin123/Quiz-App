package com.example.quiz_app.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz_app.Adapters.OptionAdapter;
import com.example.quiz_app.Models.Question;
import com.example.quiz_app.Models.Quiz;
import com.example.quiz_app.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {
    int index = 1;
    ArrayList<Quiz> quizzes;
    Map<String,Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setEventListener();
    }

    public void setEventListener() {
        Button ButtonbtnPrevious = findViewById(R.id.btnPrevious);
        Button ButtonbtnNext = findViewById(R.id.btnNext);
        Button ButtonbtnSubmit = findViewById(R.id.btnSubmit);
        ButtonbtnPrevious.setOnClickListener(previous -> {
            index--;
            bindViews();
        });
        ButtonbtnNext.setOnClickListener(next -> {
            index++;
            bindViews();
        });
        ButtonbtnSubmit.setOnClickListener(submit -> {
            Log.d("FinalQuiz", questions.toString());

            Intent intent = new Intent(this, ResultActivtiy.class);
            String json = new Gson().toJson(quizzes.get(0));
            Log.d("FINISH",json);
            intent.putExtra("QUIZ",json);
            startActivity(intent);
            finish();
        });

    }



    private void bindViews() {
//        Button ButtonbtnPrevious = findViewById(R.id.btnPrevious);
//        Button ButtonbtnNext = findViewById(R.id.btnNext);
//        Button ButtonbtnSubmit = findViewById(R.id.btnSubmit);
//
//        ButtonbtnPrevious.setVisibility(View.INVISIBLE);
//        ButtonbtnNext.setVisibility(View.INVISIBLE);
//        ButtonbtnSubmit.setVisibility(View.INVISIBLE);
//
//
//        if(index == 1){
//            // first question
//            ButtonbtnNext.setVisibility(View.VISIBLE);
//        }
//        else if(index == questions.size()){
//            // last question
//            ButtonbtnSubmit.setVisibility(View.VISIBLE);
//            ButtonbtnPrevious.setVisibility(View.VISIBLE);
//        }
//        else{
//            // middle questions
//            ButtonbtnPrevious.setVisibility(View.VISIBLE);
//            ButtonbtnNext.setVisibility(View.VISIBLE);
//        }
//
//        Question question = questions.get("question" + index);

        // Dummy Question
        Question question = new Question(
                "What is my name?",
                "Saira",
                "Sajid",
                "Jaleel",
                "Zeemal",
                "Saira"
        );

        TextView textDescription = findViewById(R.id.description);
        textDescription.setText(question.description);
        OptionAdapter optionAdapter = new OptionAdapter(this, question);
        RecyclerView optionList = findViewById(R.id.optionList);
        optionList.setLayoutManager(new LinearLayoutManager(this));
        optionList.setAdapter(optionAdapter);
        optionList.setHasFixedSize(true);
    }

}

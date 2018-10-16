package com.example.true_falsequiz;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private TextView questionNum;
    private TextView score;
    private Button trueButton;
    private Button falseButton;
    private ImageView correct;
    private ImageView wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();

        InputStream stream = getResources().openRawResource(R.raw.questions);
        String jsonString = readTextFile(stream);

        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
        Quiz quiz = new Quiz(questionList);
        startNewQuestion(quiz);

    }

    @SuppressLint("SetTextI18n")
    private void startNewQuestion(final Quiz quiz) {
        correct.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);
        display.setText(quiz.getCurrentQuestion().getQuestion());
        int number = quiz.getCurrentQuestionNum()+1;
        questionNum.setText("Question " + number);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quiz.getCurrentQuestion().getAnswer() == true) {
                    quiz.setScore(quiz.getScore() + 10);
                    correct.setVisibility(View.VISIBLE);
                } else {
                    if (quiz.getScore() - 5 >= 0) {
                        quiz.setScore(quiz.getScore() - 5);
                    }
                    wrong.setVisibility(View.VISIBLE);
                }
                //stop(2000);
                updateAndNext(quiz);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quiz.getCurrentQuestion().getAnswer() == false) {
                    quiz.setScore(quiz.getScore() + 10);
                    correct.setVisibility(View.VISIBLE);
                } else {
                    if (quiz.getScore() - 5 >= 0) {
                        quiz.setScore(quiz.getScore() - 5);
                    }
                    wrong.setVisibility(View.VISIBLE);
                }
                //stop(2000);
                updateAndNext(quiz);
            }
        });
    }

    private void stop(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateAndNext(Quiz quiz) {
        score.setText("Score: " + quiz.getScore());
        quiz.setCurrentQuestion(quiz.getCurrentQuestionNum()+1);
        startNewQuestion(quiz);
    }



    private void wireWidgets() {
        display = findViewById(R.id.textView_main_displayquestion);
        questionNum = findViewById(R.id.textView_main_questionnumber);
        score = findViewById(R.id.textView_main_score);
        trueButton = findViewById(R.id.button_main_true);
        falseButton = findViewById(R.id.button_main_false);
        correct = findViewById(R.id.imageView_main_correct);
        wrong = findViewById(R.id.imageView_main_false);
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}

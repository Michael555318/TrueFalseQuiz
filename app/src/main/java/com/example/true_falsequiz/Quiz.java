package com.example.true_falsequiz;

import java.util.List;

public class Quiz {
    private int score;
    private int currentQuestion;
    private List<Question> quiz;

    public Quiz() {
    }

    public List<Question> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Question> quiz) {
        this.quiz = quiz;
    }

    public int getCurrentQuestion() {

        return currentQuestion;
    }

    public void setCurrenQuestion(int currenQuestion) {
        this.currentQuestion = currenQuestion;
    }

    public int getScore() {

        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

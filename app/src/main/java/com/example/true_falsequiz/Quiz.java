package com.example.true_falsequiz;

import java.util.List;

public class Quiz {
    private int score;
    private int currentQuestion;
    private List<Question> quiz;

    public Quiz(List<Question> quiz) {
        this.quiz = quiz;
        score = 0;
        currentQuestion = 0;
    }

    public List<Question> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Question> quiz) {
        this.quiz = quiz;
    }

    public int getCurrentQuestionNum() {
        return currentQuestion;
    }

    public Question getCurrentQuestion() {

        return quiz.get(currentQuestion);
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getScore() {

        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

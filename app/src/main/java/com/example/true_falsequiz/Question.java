package com.example.true_falsequiz;

public class Question {
    private String question;
    private Boolean answer;

    //constructor
    public Question(String question, Boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    //Getters and Setters
    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {

        this.question = question;
    }

    public Boolean getAnswer() {

        return answer;
    }

    public String getQuestion() {

        return question;
    }

    //Other methods
    public Boolean checkAnswer(Boolean userAnswer) {
        if (userAnswer.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }
}

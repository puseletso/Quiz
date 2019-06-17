package com.puseletsomaraba.quiz.model;

public class TrueFalse {
    private int mQuestion;
    private boolean mAnswer;

    public  TrueFalse(int quesion,boolean answer){
        mQuestion=quesion;
        mAnswer=answer;


    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}

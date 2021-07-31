package com.example.mathsquizgame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Question> questions = new ArrayList<Question>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumcorrect() {
        return numcorrect;
    }

    public void setNumcorrect(int numcorrect) {
        this.numcorrect = numcorrect;
    }

    public int getNumIncorrect() {
        return numIncorrect;
    }

    public void setNumIncorrect(int numIncorrect) {
        this.numIncorrect = numIncorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    private  int numcorrect;
    private  int numIncorrect;
    private int totalQuestion;
    private int score;
    private Question currentQuestion;

    public  Game()
    {
        numcorrect=0;
        numIncorrect=0;
        totalQuestion=0;
        score=0;
        currentQuestion= new Question(10);
    }
    public void makenewQuestion(){
        currentQuestion =new Question(totalQuestion * 2 +5);
        totalQuestion++;
        questions.add(currentQuestion);

    }
    public boolean checkans(int subanswer){
        boolean isCorrect;
        if (currentQuestion.getAnswer()==subanswer){
            numcorrect++;
            isCorrect=true;
        }
        else {
            numIncorrect++;
            isCorrect=false;
        }
        score=numcorrect*10-numIncorrect*5;
        return isCorrect;
    }
}

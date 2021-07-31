package com.example.mathsquizgame;

import java.util.Random;

public class Question {
    private int firstnumber;
    private int lastnumber;
    private int answer;
    private int [] answerArray;
    private int answerposition;
    private int upperlimit;
    private String questionpharse;

    public Question(int upperlimit){
        this.upperlimit=upperlimit;
        Random randomnumbermaker= new Random();
        this.firstnumber=randomnumbermaker.nextInt(upperlimit);
        this.lastnumber=randomnumbermaker.nextInt(upperlimit);
        this.answer=this.firstnumber+lastnumber;
        this.questionpharse=firstnumber+"+"+lastnumber+"=";
        this.answerposition=randomnumbermaker.nextInt(4);
        this.answerArray=new int[] {0,1,2,3};
        this.answerArray[0]=answer+1;
        this.answerArray[1]=answer+10;
        this.answerArray[2]=answer-5;
        this.answerArray[3]=answer-2;
        this.answerArray=shuffleArray(this.answerArray);
        answerArray[answerposition]=answer;
    }
    private  int [] shuffleArray(int [] array)
    {   int index,temp;
     Random randomnumbermaker= new Random();
     for (int i=array.length-1;i>0;i--){
         index=randomnumbermaker.nextInt(i+1);
         temp = array[index];
         array[index]=array[i];
         array[i]=temp;
     }
     return array;


    }

    public int getFirstnumber() {
        return firstnumber;
    }

    public void setFirstnumber(int firstnumber) {
        this.firstnumber = firstnumber;
    }

    public int getLastnumber() {
        return lastnumber;
    }

    public void setLastnumber(int lastnumber) {
        this.lastnumber = lastnumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerposition() {
        return answerposition;
    }

    public void setAnswerposition(int answerposition) {
        this.answerposition = answerposition;
    }

    public int getUpperlimit() {
        return upperlimit;
    }

    public void setUpperlimit(int upperlimit) {
        this.upperlimit = upperlimit;
    }

    public String getQuestionpharse() {
        return questionpharse;
    }

    public void setQuestionpharse(String questionpharse) {
        this.questionpharse = questionpharse;
    }
}

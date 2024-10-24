package com.narriation;
/**
 * @author Kevin Buie
 * Creates the interface that all question
 * types will use
 */
public interface Question {
    public String getQuestion();
    public String getAnswer();
    public boolean isCorrect(String answer);
}
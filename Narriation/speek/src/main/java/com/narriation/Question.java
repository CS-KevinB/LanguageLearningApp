package com.narriation;
/**
 * @author Kevin Buie
 * Creates the interface that all question
 * types will use
 */
public interface Question {
    public String getQuestion();
    public static String getAnswer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnswer'");
    }
    public boolean isCorrect(String answer);
}

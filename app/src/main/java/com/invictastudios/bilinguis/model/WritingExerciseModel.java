package com.invictastudios.bilinguis.model;

public class WritingExerciseModel {

    private String question;
    private String answer;

    public WritingExerciseModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}

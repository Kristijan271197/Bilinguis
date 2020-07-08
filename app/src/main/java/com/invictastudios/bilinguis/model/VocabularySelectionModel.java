package com.invictastudios.bilinguis.model;

public class VocabularySelectionModel {

    private String englishWord;
    private String russianWord;
    private boolean showTranslation;

    public VocabularySelectionModel(String englishWord, String russianWord, boolean showTranslation) {
        this.englishWord = englishWord;
        this.russianWord = russianWord;
        this.showTranslation = showTranslation;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getRussianWord() {
        return russianWord;
    }

    public void setRussianWord(String russianWord) {
        this.russianWord = russianWord;
    }

    public boolean isShowTranslation() {
        return showTranslation;
    }

    public void setShowTranslation(boolean showTranslation) {
        this.showTranslation = showTranslation;
    }
}

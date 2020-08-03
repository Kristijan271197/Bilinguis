package com.invictastudios.bilinguis.model;

public class VocabularySelectionModel {

    private String englishWord;
    private String russianWord;
    private boolean showTranslation;
    private boolean soundIcon;

    public VocabularySelectionModel(String englishWord, String russianWord, boolean showTranslation, boolean soundIcon) {
        this.englishWord = englishWord;
        this.russianWord = russianWord;
        this.showTranslation = showTranslation;
        this.soundIcon = soundIcon;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getRussianWord() {
        return russianWord;
    }

    public boolean isShowTranslation() {
        return showTranslation;
    }

    public void setShowTranslation(boolean showTranslation) {
        this.showTranslation = showTranslation;
    }

    public boolean isSoundIcon() {
        return soundIcon;
    }

    public void setSoundIcon(boolean soundIcon) {
        this.soundIcon = soundIcon;
    }
}

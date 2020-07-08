package com.invictastudios.bilinguis.model;

public class MainCardsModel {

    private String mainItemName;
    private int mainItemImage;

    public MainCardsModel(String mainItemName, int mainItemImage) {
        this.mainItemName = mainItemName;
        this.mainItemImage = mainItemImage;
    }

    public String getMainItemName() {
        return mainItemName;
    }

    public void setMainItemName(String mainItemName) {
        this.mainItemName = mainItemName;
    }

    public int getMainItemImage() {
        return mainItemImage;
    }

    public void setMainItemImage(int mainItemImage) {
        this.mainItemImage = mainItemImage;
    }
}

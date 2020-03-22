package com.example.xmen.model.dto;

import com.example.xmen.strategy.DnaCrossBoardDirectionOrientations;

public class DnaCrossWord {

    private String[] dna = new String[]{};
    private String currentDnaRow;
    private int currentRowIndex;
    private int currentRowCurrentLetterIndex;
    private Character currentDnaRowLetter;
    private Integer requiredLetterMatches;


    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public String getCurrentDnaRow() {
        return currentDnaRow;
    }

    public void setCurrentDnaRow(String currentDnaRow) {
        this.currentDnaRow = currentDnaRow;
    }

    public int getCurrentRowCurrentLetterIndex() {
        return currentRowCurrentLetterIndex;
    }

    public void setCurrentRowCurrentLetterIndex(int currentRowCurrentLetterIndex) {
        this.currentRowCurrentLetterIndex = currentRowCurrentLetterIndex;
    }

    public boolean notEnoughLettersToCheckOnRow(int requiredMatches, DnaCrossBoardDirectionOrientations orientation){
        if(orientation.equals(DnaCrossBoardDirectionOrientations.RIGHT))
            return this.currentDnaRow.length() - this.currentRowCurrentLetterIndex < requiredMatches;
        else if(orientation.equals(DnaCrossBoardDirectionOrientations.LEFT))
            return this.currentRowCurrentLetterIndex + 1 < requiredMatches;
        return false;
    }

    public boolean notEnoughLettersToCheckOnColumn(int requiredMatches, DnaCrossBoardDirectionOrientations orientation){
        if(orientation.equals(DnaCrossBoardDirectionOrientations.DOWN))
            return this.dna.length - this.currentRowIndex < requiredMatches;
        else if(orientation.equals(DnaCrossBoardDirectionOrientations.UP))
            return this.currentRowIndex + 1 < requiredMatches;
        return false;
    }

    public boolean notEnoughLettersToCheckOnDiagonal(int requiredMatches, DnaCrossBoardDirectionOrientations orientation){
        if(orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_RIGHT))
            return this.notEnoughLettersToCheckOnRow(requiredMatches, DnaCrossBoardDirectionOrientations.RIGHT )
                    || this.notEnoughLettersToCheckOnColumn(requiredMatches, DnaCrossBoardDirectionOrientations.DOWN);
        else if(orientation.equals(DnaCrossBoardDirectionOrientations.UP_RIGHT))
            return this.notEnoughLettersToCheckOnRow(requiredMatches, DnaCrossBoardDirectionOrientations.RIGHT )
                    || this.notEnoughLettersToCheckOnColumn(requiredMatches, DnaCrossBoardDirectionOrientations.UP);
        else if(orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_LEFT))
            return this.notEnoughLettersToCheckOnRow(requiredMatches, DnaCrossBoardDirectionOrientations.LEFT )
                    || this.notEnoughLettersToCheckOnColumn(requiredMatches, DnaCrossBoardDirectionOrientations.DOWN);
        else if(orientation.equals(DnaCrossBoardDirectionOrientations.UP_LEFT))
            return this.notEnoughLettersToCheckOnRow(requiredMatches, DnaCrossBoardDirectionOrientations.LEFT )
                    || this.notEnoughLettersToCheckOnColumn(requiredMatches, DnaCrossBoardDirectionOrientations.UP);
        return false;
    }

    public Character getCurrentDnaRowLetter() {
        return currentDnaRowLetter;
    }

    public void setCurrentDnaRowLetter(Character currentDnaRowLetter) {
        this.currentDnaRowLetter = currentDnaRowLetter;
    }

    public int getCurrentRowIndex() {
        return currentRowIndex;
    }

    public void setCurrentRowIndex(int currentRowIndex) {
        this.currentRowIndex = currentRowIndex;
    }

    public Integer getRequiredLetterMatches() {
        return requiredLetterMatches;
    }

    public void setRequiredLetterMatches(Integer requiredLetterMatches) {
        this.requiredLetterMatches = requiredLetterMatches;
    }
}

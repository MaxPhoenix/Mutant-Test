package com.example.xmen.strategy;

import com.example.xmen.model.dto.DnaCrossWord;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class DnaCrossBoardDirectionMethodsContainer {

    private Map<DnaCrossBoardDirectionOrientations, BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>> directionalSearchMethods = new HashMap<>();

    public DnaCrossBoardDirectionMethodsContainer(){
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.RIGHT, MutantDnaSearchMethods.searchRepeatedLettersHorizontally);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.LEFT, MutantDnaSearchMethods.searchRepeatedLettersHorizontally);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.UP, MutantDnaSearchMethods.searchRepeatedLettersVertically);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.DOWN, MutantDnaSearchMethods.searchRepeatedLettersVertically);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.DOWN_RIGHT, MutantDnaSearchMethods.searchRepeatedLettersDiagonally);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.DOWN_LEFT, MutantDnaSearchMethods.searchRepeatedLettersDiagonally);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.UP_LEFT, MutantDnaSearchMethods.searchRepeatedLettersDiagonally);
        this.directionalSearchMethods.put(DnaCrossBoardDirectionOrientations.UP_RIGHT, MutantDnaSearchMethods.searchRepeatedLettersDiagonally);
    }

    public BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> getDirectionalSearchMethod(DnaCrossBoardDirectionOrientations directionalKey){
        return this.directionalSearchMethods.get(directionalKey);
    }

    public void putDirectionalSearchMethod(DnaCrossBoardDirectionOrientations directionalKey, BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> findRepeatedLettersDirectionalFunction){
        this.directionalSearchMethods.put(directionalKey, findRepeatedLettersDirectionalFunction);
    }

    public Map<DnaCrossBoardDirectionOrientations, BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>> getDirectionalSearchMethods() {
        return directionalSearchMethods;
    }

    public void setDirectionalSearchMethods(Map<DnaCrossBoardDirectionOrientations, BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>> directionalSearchMethods) {
        this.directionalSearchMethods = directionalSearchMethods;
    }
}

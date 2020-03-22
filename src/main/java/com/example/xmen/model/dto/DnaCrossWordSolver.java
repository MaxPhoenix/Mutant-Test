package com.example.xmen.model.dto;


import com.example.xmen.strategy.DnaCrossBoardDirectionMethodsContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DnaCrossWordSolver {

    private Integer mutantMatchesNeeded = 0;
    private Integer repeatedRequiredMatches = 0;

    private Map<Character, Character> allowedLetters = new HashMap<>();

    public boolean isMutant (String [] dna){
        DnaCrossWord dnaCrossWord = new DnaCrossWord();
        dnaCrossWord.setDna(dna);
        dnaCrossWord.setRequiredLetterMatches(this.repeatedRequiredMatches);

        if(this.isValidDnaToBeChecked(dna)){
            String crossWordRow;
            int mutatedMatches = 0;
            for(int crossWordRowIndex = 0; crossWordRowIndex < dna.length; crossWordRowIndex++) {
                crossWordRow = dna[crossWordRowIndex];

                if (this.isValidPieceOfDnaToBeChecked(dna, crossWordRow)) {
                    dnaCrossWord.setCurrentDnaRow(dna[crossWordRowIndex]);
                    dnaCrossWord.setCurrentRowIndex(crossWordRowIndex);

                    for (int crossWordColIndex = 0; crossWordColIndex < crossWordRow.length(); crossWordColIndex++) {
                        dnaCrossWord.setCurrentDnaRowLetter(crossWordRow.charAt(crossWordColIndex));
                        dnaCrossWord.setCurrentRowCurrentLetterIndex(crossWordColIndex);

                        if (this.allowedLetters.get(dnaCrossWord.getCurrentDnaRowLetter()) == null)
                            throw new IllegalArgumentException("Solo se puede evaluar el ADN que contengan las letras" + this.allowedLetters.values());

                        mutatedMatches += this.getMutatedMatches(dnaCrossWord);
                    }

                    if (mutatedMatches >= this.mutantMatchesNeeded)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPieceOfDnaToBeChecked(String[] dna, String crossWordRow) {
        if(crossWordRow.length() < dna.length)
            throw new IllegalArgumentException("Las porciones de ADN deben tener la misma longitud que la lista de porciones.");
        return true;
    }

    private boolean isValidDnaToBeChecked(String[] dna){
        if(dna.length < mutantMatchesNeeded)
            throw  new IllegalArgumentException("Se requiere un DNA con " + this.mutantMatchesNeeded + " filas y " + this.mutantMatchesNeeded + "columnas.");
        return true;
    }

    private int getMutatedMatches(DnaCrossWord dnaCrossWord){
        DnaCrossBoardDirectionMethodsContainer directionalMethodsContainer = new DnaCrossBoardDirectionMethodsContainer();
        AtomicReference<Integer> mutatedMatches = new AtomicReference<>(0);

        directionalMethodsContainer.getDirectionalSearchMethods().forEach((directionalFuntionKey, directionalFunction) ->{
            boolean mutatedDnaFoundInDirection =  directionalFunction.apply(dnaCrossWord, directionalFuntionKey);
            if(mutatedDnaFoundInDirection)
                mutatedMatches.set(mutatedMatches.get() + 1);
        });

        return mutatedMatches.get();
    }

    public Integer getMutantMatchesNeeded() {
        return mutantMatchesNeeded;
    }

    public void setMutantMatchesNeeded(Integer mutantMatchesNeeded) {
        this.mutantMatchesNeeded = mutantMatchesNeeded;
    }

    public Map<Character, Character> getAllowedLetters() {
        return allowedLetters;
    }

    public void setAllowedLetters(Map<Character, Character> allowedLetters) {
        this.allowedLetters = allowedLetters;
    }

    public Integer getRepeatedRequiredMatches() {
        return repeatedRequiredMatches;
    }

    public void setRepeatedRequiredMatches(Integer repeatedRequiredMatches) {
        this.repeatedRequiredMatches = repeatedRequiredMatches;
    }
}

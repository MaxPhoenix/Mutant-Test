package com.example.xmen.services;

import com.example.xmen.model.dto.DnaCrossWordSolver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MutantTestService {

    public boolean isMutant(String[] dna){
        DnaCrossWordSolver dnaCrossWordSolver = new DnaCrossWordSolver();
        dnaCrossWordSolver.setAllowedLetters(getAllowedLetersMap('A','T','C','G'));
        dnaCrossWordSolver.setMutantMatchesNeeded(2);
        dnaCrossWordSolver.setRepeatedRequiredMatches(4);

        return dnaCrossWordSolver.isMutant(dna);
    }

    private static Map<Character, Character> getAllowedLetersMap(Character... letters){
        Map<Character, Character> allowedLetters = new HashMap<>();
        for(Character letter : letters)
            allowedLetters.put(letter, letter);
        return allowedLetters;
    }
}

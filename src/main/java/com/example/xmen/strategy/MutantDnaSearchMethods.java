package com.example.xmen.strategy;

import com.example.xmen.model.dto.DnaCrossWord;
import java.util.function.BiFunction;

public class MutantDnaSearchMethods {

    public static final BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>
            searchRepeatedLettersHorizontally = (dnaCrossWord, orientation) -> {
        if(dnaCrossWord.notEnoughLettersToCheckOnRow(dnaCrossWord.getRequiredLetterMatches(),orientation))
            return false;

        if(!orientation.equals(DnaCrossBoardDirectionOrientations.RIGHT)
                && !orientation.equals(DnaCrossBoardDirectionOrientations.LEFT)) {
            throw  new IllegalArgumentException("Se debe ingresar las direcciones izquierda o derecha para buscar horizontalmente.");
        }

        Integer currentRowLetterColumn = dnaCrossWord.getCurrentRowCurrentLetterIndex();
        String currentRow = dnaCrossWord.getCurrentDnaRow();
        Character currentRowLetter = dnaCrossWord.getCurrentDnaRowLetter();

        char letter;
        int currentMatches = 0;
        boolean rightSearch =  orientation.equals(DnaCrossBoardDirectionOrientations.RIGHT);
        for(int colIndex = currentRowLetterColumn; ; colIndex = modifyIndexBasedOnOrientation(rightSearch, colIndex)){
            letter = currentRow.charAt(colIndex);
            if(currentRowLetter == letter)
                currentMatches++;
            else
                return false;
            if(currentMatches == dnaCrossWord.getRequiredLetterMatches())
                return true;
        }
    };


    public static final BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>
            searchRepeatedLettersVertically = (dnaCrossWord, orientation) -> {
        if(dnaCrossWord.notEnoughLettersToCheckOnColumn(dnaCrossWord.getRequiredLetterMatches(), orientation))
            return false;

        if(!orientation.equals(DnaCrossBoardDirectionOrientations.UP)
                && !orientation.equals(DnaCrossBoardDirectionOrientations.DOWN)) {
            throw  new IllegalArgumentException("Se debe ingresar las direcciones arriba o abajo para buscar verticalmente.");
        }

        Integer currentDnaRowIndex = dnaCrossWord.getCurrentRowIndex();
        Integer currentDnaRowLetterIndex = dnaCrossWord.getCurrentRowCurrentLetterIndex();
        char currentRowLetter = dnaCrossWord.getCurrentDnaRowLetter();

        String dnaRow;
        char letter;
        int currentMatches = 0;
        boolean isDownSearch = orientation.equals(DnaCrossBoardDirectionOrientations.DOWN);
        for(int rowIndex = currentDnaRowIndex; ;  rowIndex = modifyIndexBasedOnOrientation(isDownSearch, rowIndex)){
            dnaRow = dnaCrossWord.getDna()[rowIndex];
            letter = dnaRow.charAt(currentDnaRowLetterIndex);
            if(currentRowLetter == letter)
                currentMatches++;
            else
                return false;
            if(currentMatches == dnaCrossWord.getRequiredLetterMatches())
                return true;
        }
    };

    public static final BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean>
            searchRepeatedLettersDiagonally = (dnaCrossWord, orientation) -> {
        if(dnaCrossWord.notEnoughLettersToCheckOnDiagonal(dnaCrossWord.getRequiredLetterMatches(), orientation))
            return false;

        if(!orientation.equals(DnaCrossBoardDirectionOrientations.UP_LEFT)
                && !orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_LEFT)
                && !orientation.equals(DnaCrossBoardDirectionOrientations.UP_RIGHT)
                && !orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_RIGHT)) {
            throw  new IllegalArgumentException("No se encuentra una búsqueda diagonal para la orientación solicitada.");
        }

        Integer currentDnaRowIndex = dnaCrossWord.getCurrentRowIndex();
        Integer currentRowLetterColumn = dnaCrossWord.getCurrentRowCurrentLetterIndex();
        char currentRowLetter = dnaCrossWord.getCurrentDnaRowLetter();

        String dnaRow;
        char letter;
        int rowIndex = currentDnaRowIndex;
        int currentMatches = 0;
        boolean isRightSearch = orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_RIGHT)
                || orientation.equals(DnaCrossBoardDirectionOrientations.UP_RIGHT);
        boolean isDownSearch = orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_RIGHT)
                || orientation.equals(DnaCrossBoardDirectionOrientations.DOWN_LEFT);

        for(int colIndex = currentRowLetterColumn; ; colIndex = modifyIndexBasedOnOrientation(isRightSearch, colIndex)){
            dnaRow = dnaCrossWord.getDna()[rowIndex];
            letter = dnaRow.charAt(colIndex);
            if(currentRowLetter == letter)
                currentMatches++;
            else
                return false;
            if(currentMatches == dnaCrossWord.getRequiredLetterMatches())
                return true;
            rowIndex = modifyIndexBasedOnOrientation(isDownSearch, rowIndex);
        }

    };

    private static int modifyIndexBasedOnOrientation(boolean orientationSearch, int colIndex){
        if (orientationSearch)
            colIndex++;
         else
            colIndex--;
         return colIndex;

    }


}

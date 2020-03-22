package com.example.xmen.demo;

import com.example.xmen.model.dto.DnaCrossWord;
import com.example.xmen.strategy.DnaCrossBoardDirectionOrientations;
import com.example.xmen.strategy.MutantDnaSearchMethods;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Test
	public void searchRepeatedLettersToTheRightTest(){
		String validDna = "CCCCTA";
		String invalidDna = "ATGCGA";
		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordRight(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersHorizontally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.RIGHT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordRight(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.RIGHT);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordRight(String validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setCurrentDnaRow(validDna);
		dnaCrossWord.setCurrentRowIndex(0);
		dnaCrossWord.setCurrentDnaRowLetter(validDna.charAt(0));
		dnaCrossWord.setCurrentRowCurrentLetterIndex(0);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}


	@Test
	public void searchRepeatedLettersToTheLeftTest(){
		String validDna = "ATCCCC";
		String invalidDna = "ATGCGA";
		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordLeft(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersHorizontally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.LEFT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordLeft(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.LEFT);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordLeft(String validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setCurrentDnaRow(validDna);
		dnaCrossWord.setCurrentRowIndex(0);
		dnaCrossWord.setCurrentDnaRowLetter(validDna.charAt(validDna.length()-1));
		dnaCrossWord.setCurrentRowCurrentLetterIndex(validDna.length()-1);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}



	@Test
	public void searchRepeatedLettersDownTest(){
		String [] validDna = {"C","C","C","C"};
		String [] invalidDna = {"C","C","A","C"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWord(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersVertically;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWord(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWord(String[] validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setDna(validDna);
		dnaCrossWord.setCurrentDnaRow(validDna[0]);
		dnaCrossWord.setCurrentRowIndex(0);
		dnaCrossWord.setCurrentDnaRowLetter(validDna[0].charAt(0));
		dnaCrossWord.setCurrentRowCurrentLetterIndex(0);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}

	@Test
	public void searchRepeatedLettersUpTest(){
		String [] validDna = {"C","C","C","C"};
		String [] invalidDna = {"C","C","A","C"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordUp(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersVertically;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordUp(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordUp(String[] validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setDna(validDna);
		dnaCrossWord.setCurrentDnaRow(validDna[0]);
		dnaCrossWord.setCurrentRowIndex(validDna.length-1);
		dnaCrossWord.setCurrentDnaRowLetter(validDna[0].charAt(0));
		dnaCrossWord.setCurrentRowCurrentLetterIndex(0);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}

	@Test
	public void searchRepeatedLettersDownRightTest(){
		String[] validDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG"};
		String [] invalidDna = {"ATGCGA","CGGTGC","TTATGT","AGAAGG"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWord(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersDiagonally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN_RIGHT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWord(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN_RIGHT);
		assertFalse(isMutantDna);
	}

	@Test
	public void searchRepeatedLettersUpRightTest(){
		String[] validDna = {"ATGAGA","CAATGC","TAATGT","AGAAGG"};
		String [] invalidDna = {"ATGCGA","CGGTGC","TTATGT","AGAAGG"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordUpRight(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersDiagonally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP_RIGHT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordUpRight(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP_RIGHT);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordUpRight(String[] validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setDna(validDna);
		dnaCrossWord.setCurrentDnaRow(validDna[validDna.length - 1]);
		dnaCrossWord.setCurrentRowIndex(validDna.length - 1);
		char lastRowLetter = dnaCrossWord.getCurrentDnaRow().charAt(0);
		dnaCrossWord.setCurrentDnaRowLetter(lastRowLetter);
		dnaCrossWord.setCurrentRowCurrentLetterIndex(0);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}

	@Test
	public void searchRepeatedLettersDownLeftTest(){
		String[] validDna = {"AAGCGC","CAGACC","TTACAT","AGCAGA"};
		String [] invalidDna = {"ATGCGA","CGGTGC","TTATGT","AGAAGG"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordDownLeft(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersDiagonally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN_LEFT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordDownLeft(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.DOWN_LEFT);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordDownLeft(String[] validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setDna(validDna);
		dnaCrossWord.setCurrentDnaRow(validDna[0]);
		dnaCrossWord.setCurrentRowIndex(0);
		char lastRowLetter = dnaCrossWord.getCurrentDnaRow().charAt(dnaCrossWord.getCurrentDnaRow().length()-1);
		dnaCrossWord.setCurrentDnaRowLetter(lastRowLetter);
		dnaCrossWord.setCurrentRowCurrentLetterIndex(dnaCrossWord.getCurrentDnaRow().length()-1);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}

	@Test
	public void searchRepeatedLettersUpLeftTest(){
		String[] validDna = {"ATGCGA","CAGGGC","TTATGT","AGAAGG"};
		String [] invalidDna = {"ATGCGA","CGGTGC","TTATGT","AGAAGG"};

		DnaCrossWord dnaCrossWord = this.getDnaCrossWordWithWordUpLeft(validDna);

		BiFunction<DnaCrossWord, DnaCrossBoardDirectionOrientations, Boolean> searchRepeatedLetterToRight = MutantDnaSearchMethods.searchRepeatedLettersDiagonally;
		boolean isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP_LEFT);
		assertTrue(isMutantDna);

		dnaCrossWord = this.getDnaCrossWordWithWordUpLeft(invalidDna);
		isMutantDna = searchRepeatedLetterToRight.apply(dnaCrossWord, DnaCrossBoardDirectionOrientations.UP_LEFT);
		assertFalse(isMutantDna);
	}

	private DnaCrossWord getDnaCrossWordWithWordUpLeft(String[] validDna) {
		DnaCrossWord dnaCrossWord = new DnaCrossWord();
		dnaCrossWord.setDna(validDna);
		dnaCrossWord.setCurrentDnaRow(validDna[validDna.length - 1]);
		dnaCrossWord.setCurrentRowIndex(validDna.length - 1);
		char lastRowLetter = dnaCrossWord.getCurrentDnaRow().charAt(dnaCrossWord.getCurrentDnaRow().length() - 1);
		dnaCrossWord.setCurrentDnaRowLetter(lastRowLetter);
		dnaCrossWord.setCurrentRowCurrentLetterIndex(dnaCrossWord.getCurrentDnaRow().length()-1);
		dnaCrossWord.setRequiredLetterMatches(4);
		return dnaCrossWord;
	}


}

package com.callor.word;

import com.callor.word.impl.WordServiceImplV1;

public class WordEx_01 {

	public static void main(String[] args) {
		
		WordService wService = new WordServiceImplV1();
		wService.printWord();
		wService.viewWord();
		wService.saveScore();
	}
}

package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.WordService;
import com.callor.word.model.WordVO;

public class WordServiceImplV1 implements WordService {

	protected List<WordVO> wordList;
	protected Scanner scan;
	protected final int 영어 = 0;
	protected final int 한글 = 0;
	WordVO wordVO = new WordVO();
	public WordServiceImplV1() {
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		this.loadWord();
	}

	@Override
	public void loadWord() {
		String wordFile = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;

				String words[] = reader.split(":");

				WordVO wordVO = new WordVO();			
				wordVO.setEnglish(words[영어]);
				wordVO.setKorea(words[한글]);
				wordList.add(wordVO);

			}

			buffer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 여는 동안 문제 발생");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽는 동안 문제 발생");
		}

	}

	@Override
	public void printWord() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewWord() {
		
		
		Random rnd = new Random();
		Integer totalCount = 10;
		
		while (true) {
			WordVO wordVO = this.getWord();
			String strEng = wordVO.getEnglish();
			String strWords[] = strEng.split("");

			for (int i = 0; i < 100; i++) {
				int index1 = rnd.nextInt(strWords.length);
				int index2 = rnd.nextInt(strWords.length);

				String temp = strWords[index1];
				strWords[index1] = strWords[index2];
				strWords[index2] = temp;
			}
			

			System.out.println("=".repeat(80));
			System.out.println("제시된 영 단어를 바르게 배열하시오(QUIT: 게임종료, Enter : 건너뛰기(-1점)");
			System.out.println("힌트 : " + wordVO.getKorea());
			System.out.println(Arrays.toString(strWords));
			System.out.println("=".repeat(80));
			System.out.print(">> ");
			String strInput = scan.nextLine();
			if (strInput.equals("QUIT")) {
				System.out.println("Game Over!!");
				return;
			}
			if(strInput.equals("")) {
				totalCount--;
				System.out.println("점수 : " + totalCount);
				System.out.println("New QUIZ!!");
				continue;
			}
			if (strInput.equalsIgnoreCase(wordVO.getEnglish())) {
				System.out.println("정답입니다");
				totalCount++;
				totalCount++;
				totalCount++;
				System.out.println("점수 : " + (totalCount));
			} else {
				for (int i = 0; i < 3; i++) {
					System.out.println("재도전하시겠습니까?(YES: -1점 NO : nextQUIZ)");
					System.out.print(">> ");
					String reStart = scan.nextLine();
					if (reStart.equals("YES")) {
						totalCount--;
						System.out.println("점수 : " + (totalCount));
					}
					if (totalCount < 0) {
						totalCount++;
						System.out.println("점수가 0점입니다 Next QUIZ!!");
						break;
					} else if (reStart.equals("NO")) {
						break;
					}
					System.out.println("힌트 : -1점, Enter : Pass");
					System.out.print(">> ");
					String hint = scan.nextLine();
					if (hint.equals("힌트")) {
						if (totalCount < 1) {
							System.out.println("점수가 부족합니다");
							totalCount++;
							continue;
						} else {
							System.out.println("힌트 : " + wordVO.getKorea());
							totalCount--;
							System.out.println("점수 : " + (totalCount));
						}

					}

					System.out.print(">> ");
					strInput = scan.nextLine();

					if (strInput.equalsIgnoreCase(wordVO.getEnglish())) {
						System.out.println("정답입니다");
						totalCount++;
						totalCount++;
						totalCount++;
						System.out.println("점수 : " + (totalCount));
						break;
					} else {
						continue;
					}
				}
				System.out.println("New QUIZ!!");
			}
			wordVO.setCount(totalCount);
			continue;
		}
	}

	protected WordVO getWord() {
		Random rnd = new Random();
		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);
		wordVO = wordList.get(num);
		return wordVO;
		
	}

	@Override
	public void saveScore() {

		String fileName = null;
		while (true) {
			System.out.println("파일 이름을 입력하세요");
			System.out.print(">> ");
			fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("파일이름은 반드시 입력해야 합니다");
				continue;
			}
			break;
		}
		String strFileName = "src/com/callor/word/" + fileName +".txt";

		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(strFileName);
			out = new PrintWriter(fileWriter);
			out.println(wordVO.getCount());
			System.out.println(wordVO.getCount());
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadScore() {
		// TODO Auto-generated method stub
		String fileName = "src/com/callor/word/wordScore.txt";
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			
			Integer result = fileReader.read(); 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

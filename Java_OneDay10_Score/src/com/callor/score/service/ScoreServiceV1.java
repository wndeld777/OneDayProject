package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {
	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	ScoreVO scoreVO;
	String strName;
	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		scoreVO = new ScoreVO();
	}

	public void menuScore() {
		Integer intMenu = null;
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 시스템 2021");
			System.out.println("-".repeat(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();
			if (strMenu.equals("QUIT")) {
				break;
			}
			
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("메뉴 선택 오류");
				System.out.println("메뉴는 1 ~ 2, QUIT 만 입력가능");
				continue;
			}
			if (intMenu == 1) {
				this.strName();
				this.inputScore();
				this.printScore();
			} else if (intMenu == 2) {
				this.printList();
			}
			return;
		}
	}
	
	public void strName() {
		while (true) {
			ScoreVO scoreVO = new ScoreVO();
			System.out.println("=".repeat(60));
			System.out.println("학생 이름을 입력하세요( 입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(60));
			System.out.print("이름 >> ");
			String strName = scan.nextLine();
			if(strName.equals("QUIT")) {
				break;
			}else {
				scoreVO.setName(strName);
			}
			
		}

	}

	public void inputScore() {
		this.strName();
		
		int nSize = scoreList.size();
		scoreVO.setName(strName);
		Integer intKor = null;
		Integer intEng = null;
		Integer intMath = null;
		Integer intSci = null;
		Integer intHis = null;
		while (true) {
			System.out.println(scoreVO.getName() + " 학생이름의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)");
			System.out.print("국어 >> ");
			String strKor = scan.nextLine();
			if (strKor.equals("QUIT")) {
				return ;
			}
			intKor = Integer.valueOf(strKor);
			if (intKor < 0 || intKor > 100) {
				System.out.println("성적은 0 ~ 100 까지만 입력하세요");
			} else {
				break;
			}

		}
		while (true) {
			System.out.print("영어 >> ");
			String strEng = scan.nextLine();
			if (strEng.equals("QUIT")) {
				return;
			}
			intEng = Integer.valueOf(strEng);
			if (intEng < 0 || intEng > 100) {
				System.out.println("성적은 0 ~ 100 까지만 입력하세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.print("수학 >> ");
			String strMath = scan.nextLine();
			if (strMath.equals("QUIT")) {
				return;
			}
			intMath = Integer.valueOf(strMath);
			if (intMath < 0 || intMath > 100) {
				System.out.println("성적은 0 ~ 100 까지만 입력하세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.print("과학 >> ");
			String strSci = scan.nextLine();
			if (strSci.equals("QUIT")) {
				return;
			}
			intSci = Integer.valueOf(strSci);
			if (intSci < 0 || intSci > 100) {
				System.out.println("성적은 0 ~ 100 까지만 입력하세요");
			} else {
				break;
			}
		}
		while (true) {
			System.out.print("국사 >> ");
			String strHis = scan.nextLine();
			if (strHis.equals("QUIT")) {
				return;
			}
			intHis = Integer.valueOf(strHis);
			if (intHis < 0 || intHis > 100) {
				System.out.println("성적은 0 ~ 100 까지만 입력하세요");
			} else {
				break;
			}
		}

		System.out.println("=".repeat(60));
		System.out.println(scoreVO.getName() + "학생의 성적이 추가 되었습니다");
		System.out.println("=".repeat(60));
		System.out.println("국어 : " + intKor);
		System.out.println("영어 : " + intEng);
		System.out.println("수학 : " + intMath);
		System.out.println("과학 : " + intSci);
		System.out.println("국사 : " + intHis);

		Integer scoreSum = intKor + intEng + intMath + intSci + intHis;
		float flaotAvg = (float) scoreSum / 5;

		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setKor(intKor);
		scoreVO.setEng(intEng);
		scoreVO.setMath(intMath);
		scoreVO.setSci(intSci);
		scoreVO.setHis(intHis);
		scoreVO.setSum(scoreSum);
		scoreVO.setAvg(flaotAvg);
		scoreList.add(scoreVO);
		return;
	} // inputScore()

	public void printScore() {

		this.printList();

		for (int i = 0; i < scoreList.size(); i++) {

			ScoreVO scoreVO = scoreList.get(i);
			System.out.print(scoreVO.getName() + "\t");
			System.out.print(scoreVO.getKor() + "\t");
			System.out.print(scoreVO.getEng() + "\t");
			System.out.print(scoreVO.getMath() + "\t");
			System.out.print(scoreVO.getSci() + "\t");
			System.out.print(scoreVO.getHis() + "\t");
			System.out.print(scoreVO.getSum() + "\t");
			System.out.println(scoreVO.getAvg() + "\n");

		}
		return;
	}

	public void printList() {
		System.out.println("=".repeat(60));
		System.out.println("* 빛나라 고교 성적리스트 *");
		System.out.println("=".repeat(60));
		System.out.println("이름\t국어\t영어\t수학\t과학\t역사\t총점\t평균");
		System.out.println("-".repeat(60));

	}

}

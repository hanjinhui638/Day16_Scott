package com.jh.input;

import java.util.Scanner;

import com.jh.salgrade.SalgradeDTO;

public class SalInput {
	private Scanner sc;
	private int grade;
	private int losal;
	private int hisal;

	public SalInput() {
		sc = new Scanner(System.in);
	}
	
	
	

	// 등급 급여 입력하기

	public SalgradeDTO insert() {

		SalgradeDTO salgradeDTO = new SalgradeDTO();

		System.out.println("등급을 입력하세요");
		int g = sc.nextInt();						
		salgradeDTO.setGrade(grade);
		System.out.println("최소급여를 입력하세요");
		int l = sc.nextInt();
		salgradeDTO.setLosal(losal);
		System.out.println("최대급여를 입력하세요");
		int h = sc.nextInt();
		salgradeDTO.setHisal(hisal);

		return salgradeDTO;

	}

	// 등급을 통해서 최소급여와 최대급여를 찾기

	public int gradeinput() {
		int grade = 0;
		System.out.println("등급을 입력하세요");
		grade = sc.nextInt();

		return grade;
	}
}

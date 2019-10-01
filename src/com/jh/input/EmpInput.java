package com.jh.input;

import java.util.Scanner;

public class EmpInput {
	
	Scanner sc = null;

	public EmpInput() {
		sc = new Scanner(System.in);
		
	}
	
	//empnoInput
	//사원번호를 입력하세요
	
	public int empnoInput() {
		int empno = 0;
		System.out.println("사원 번호를 입력");
		empno = sc.nextInt();
		return empno;
		
	}
	

}

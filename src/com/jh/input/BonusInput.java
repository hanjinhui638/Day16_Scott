package com.jh.input;

import java.util.Scanner;

import com.jh.bonus.BonusDTO;

public class BonusInput {
	
	Scanner sc = null;
	
	public BonusInput() {
		sc = new Scanner(System.in);
	}
	
	public BonusDTO insert() {
		BonusDTO bonusDTO = new BonusDTO(); //?
		
		System.out.println("사원이름을 입력");
		String ename = sc.next();
		
		System.out.println("job을 입력");
		String job = sc.next();
		
		System.out.println("sal을 입력");
		int sal = sc.nextInt();
		
		System.out.println("comm을 입력");
		int comm = sc.nextInt();
		
		return
		
		
	}

}

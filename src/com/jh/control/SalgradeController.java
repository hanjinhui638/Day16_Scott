package com.jh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.jh.salgrade.SalgradeDAO;
import com.jh.salgrade.SalgradeDTO;

public class SalgradeController {
	
	private Scanner sc;
	private SalgradeDAO salDAO;

	public SalgradeController() {
		sc = new Scanner(System.in);
		salDAO = new SalgradeDAO();
	}
	
	public void start() {
		
		boolean check = true;
		int select = 0;
		
		while(check) {
			System.out.println("1. salgrade 전체 출력");
			System.out.println("2. salgrade 검색출력");
			System.out.println("3. salgrade 정보입력");
			System.out.println("4. salgrade 정보삭제");
			System.out.println("5. 종  료 ");
			
			select = sc.nextInt();
			
			switch(select) {
			case 1 :
				ArrayList<SalgradeDTO> ar = salDAO.getSalectList();
				if(ar.size()>0) {
					
				}else {
					
				}
				
				break;
			
			case 2: 
			
			case 3:
				
				
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				
				break;
				
			case 4:
				
			default :
				check= !check;
			}
			
		}
	}
}

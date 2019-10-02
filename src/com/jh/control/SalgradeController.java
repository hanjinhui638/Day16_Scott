package com.jh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.jh.input.SalInput;
import com.jh.salgrade.SalgradeDAO;
import com.jh.salgrade.SalgradeDTO;
import com.jh.view.Salview;

public class SalgradeController {
	
	private Scanner sc;
	private SalgradeDAO salDAO;
	private Salview salView;
	private SalInput salInput;
	private int grade;

	public SalgradeController() {
		sc = new Scanner(System.in);
		salDAO = new SalgradeDAO();
		salView = new Salview();
		salInput = new SalInput();
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
					
					salView.view(ar);
					
				}else {
					salView.view("데이터가 없습니다.");
				}
				
				break;
			
			case 2: 
				select = salInput.gradeinput();
				SalgradeDTO salgradeDTO = salDAO.getSalgradeOne(select);
				if(salgradeDTO !=null) {
					salView.view(salgradeDTO);
				}else {
					salView.view("없는 사원 번호입니다.");
				}
			case 3:
				SalgradeDTO salgradeDTO2 = salInput.insert();
				select = salDAO.salInsert(salgradeDTO2);
				
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				salView.view(s);
				break;
				
			case 4:
				select = salDAO.saldelete(grade);
				if(select>0) {
					salView.view("삭제하였습니다.");
				}else {
					salView.view("없는 등급입니다.");
				}
				
				
			default :
				check= !check;
			}
			
		}
	}
}

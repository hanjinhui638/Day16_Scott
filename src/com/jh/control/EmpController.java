package com.jh.control;

import java.util.Scanner;

import com.jh.emp.EmpDTO;
import com.jh.view.EmpView;

public class EmpController {
	
	
	//start 
	//1. 사원전체정보출력
	//2. 사원검색출력
	//3. 종료 
	
	// com.iu.dept.DeptDTO
	// com.iu.dept.DeptDAO
	// com.iu.view.DeptView 
	// com.iu.input.DeptInput 
	// com.iu.controll.DeptController
	
	private Scanner sc;
	private EmpView ev;
	private EmpDTO ed;
	
	public EmpController() {
		sc = new Scanner(System.in);
		ev = new EmpView();
		ed = new EmpDTO();
	}
	
	public void start() {
		
		boolean check = true; 
		int select = 0;
		
		while(check) {
			System.out.println("1. 사원전체정보출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 종료");
			
			select = sc.nextInt();
			
			switch(select) {
			case 1 : 
				
				
			
			case 2 : 
				ev.view(ar);
				
			case 3: 
				check = false;
				break;
			
			default :
				System.out.println("잘못된 번호");
				break;
			}
			
			
		}
		
		
		
		
	}

}

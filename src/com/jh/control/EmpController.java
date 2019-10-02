package com.jh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.jh.emp.EmpDAO;
import com.jh.emp.EmpDTO;
import com.jh.input.EmpInput;
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
	private EmpDAO empDAO;
	private EmpView empView;
	private EmpInput empInput;
	
	public EmpController() {
		sc = new Scanner(System.in);
		empDAO = new EmpDAO();
		empView = new EmpView();
		empInput = new EmpInput();
	}
	
	public void start() {
		
		boolean check = true; 
		int select = 0;
		
		while(check) {
			System.out.println("1. 사원정보전체출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 사원정보입력");
			System.out.println("4. 사원정보삭제");
			System.out.println("5. 사원이름검색");
			System.out.println("3. 종료");
			
			select = sc.nextInt();
			
			switch(select) {
			case 1 : 
				ArrayList<EmpDTO> ar= empDAO.getSelectList();
				if(ar.size()>0) {
				
				empView.view(ar);
				}else {
					empView.view("데이터가 없습니다.");
				}
				
				
				break;
			
			case 2 : 
				select = empInput.empnoInput();
				EmpDTO empDTO = empDAO.getSelectOne(select);
				if(empDTO !=null) {
					empView.view(empDTO);
				}else {
					empView.view("없는 사원 번호입니다.");
				}
				
				break;
				
			case 3:
				EmpDTO empDTO2 = empInput.insert();
				select = empDAO.empInsert(empDTO2);
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				empView.view(s);
				break;
				
			case 4:	
				select = empInput.empnoInput();
				EmpDTO empDTO3 = empDAO.getSelectOne(select);
				if(empDTO !=null) {
					empDAO.delete();
				}else {
					empView.view("없는 사원 번호입니다.");
				}
				
			default :
				check=!check;
				
			}
			
			
		}
		
		
		
		
	}

}

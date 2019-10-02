package com.jh.control;

import java.util.List;
import java.util.Scanner;

import com.jh.dept.DeptDAO;
import com.jh.dept.DeptDTO;
import com.jh.input.DeptInput;
import com.jh.view.DeptView;

public class DeptController {

	private Scanner sc;
	private DeptView deptView;
	private DeptDAO dao;
	private DeptInput deptInput;
	
	public DeptController() {
		sc = new Scanner(System.in);
		dao = new DeptDAO();
		deptView = new DeptView();
		deptInput = new DeptInput();
		
	}
	public void start() {
		
		boolean check = true; 
		int select = 0;
		
		while(check) {
			System.out.println("1. 사원정보전체출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 부서정보추가");
			System.out.println("4. 종료");
			
			select = sc.nextInt();
			
			switch(select) {
			case 1 : 
				List<DeptDTO> ar= dao.deptSelectList();
				if(ar.size()>0) {
				
					deptView.view(ar);
				}else {
					deptView.view("데이터가 없습니다.");
				}
				
				
				break;
			
			case 2 : 
				select = deptInput.deptInfo();
				DeptDTO deptDTO = dao.deptSelectOne(select);
				if(deptDTO !=null) {
					deptView.view(deptDTO);
				}else {
					deptView.view("없는 사원 번호입니다.");
				}
				
				break;
			
			case 3 :
				DeptDTO deptDTO2 = deptInput.insert();
				select = dao.deptInsert(deptDTO2);
				String s = "Insert Fail";
				if(select>0) {
					s="Insert Success";
					
				}
				deptView.view(s);
				break;
			
			default :
				check=!check;
				
			}
	}
	}
}

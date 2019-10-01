package com.jh.scott;

import com.jh.emp.EmpDAO;
import com.jh.emp.EmpDTO;
import com.jh.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		EmpDAO empDAO = new EmpDAO();
		EmpView ev = new EmpView();
		EmpDTO empDTO = empDAO.getSelectOne(7900);
		
		
		if(empDTO !=null) {
			ev.view(empDTO);
		}else {
			System.out.println("없는 번호 입니다.");
		}
		
		empDAO.getSelectList();
	
		
		
		
	}

}

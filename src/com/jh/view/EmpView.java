package com.jh.view;

import java.util.ArrayList;

import com.jh.emp.EmpDTO;

public class EmpView {
	public void view(String str) {
		System.out.println(str);
		
	}

	public void view(EmpDTO empDTO) {
		System.out.println("-------------------------");
		System.out.println("Empno : " + empDTO.getEmpno());
		System.out.println("Ename : " + empDTO.getEname());
		System.out.println("Job : " + empDTO.getJob());
		System.out.println("Mgr : " + empDTO.getMgr());
		System.out.println("Hiredate : " + empDTO.getHiredate());
		System.out.println("Sal : "+ empDTO.getSal());
		System.out.println("Comm : "+ empDTO.getComm());
		System.out.println("Deptno : " + empDTO.getDeptno());
	}
	
	public void view(ArrayList<EmpDTO> ar) {
		for(EmpDTO empDTO:ar) {
			
			this.view(empDTO);

		}
		
	}
}

package com.jh.view;

import java.util.List;

import com.jh.dept.DeptDTO;

public class DeptView {
	public void view(List<DeptDTO> ar) {
		for(DeptDTO deptDTO:ar) {
			this.view(deptDTO);
		}
		
	}
	
	public void view(DeptDTO deptDTO) {
		System.out.println("------------------------");
		System.out.println("Deptno : " +deptDTO.getDeptno());
		System.out.println("Dname : " +deptDTO.getDname());
		System.out.println("Loc :" + deptDTO.getLoc());
	}
	
	public void view(String str) {
		System.out.println(str);
	}
	
}

package com.jh.input;

import java.util.Scanner;

import com.jh.dept.DeptDTO;



public class DeptInput {

		Scanner sc = null;
		
		public DeptInput() {
			sc = new Scanner(System.in);
		}
		
		//메서드명 insert
		
		public DeptDTO insert() {
			DeptDTO deptDTO = new DeptDTO();
			
			System.out.println("부서번호를 입력");
			int deptno = sc.nextInt();
			deptDTO.setDeptno(deptno);
	
			System.out.println("부서명을 입력");
			String dname = sc.next();
			deptDTO.setDname(dname);
			
			System.out.println("지역 입력");
			String loc = sc.next();
			deptDTO.setLoc(loc);
		
			return deptDTO;
		}
		
		
		public int deptInfo() {
			int deptno = 0;
			System.out.println("부서번호를 입력");
			deptno = sc.nextInt();
			return deptno;
			
		}
}

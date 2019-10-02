package com.jh.input;

import java.util.Scanner;

import com.jh.emp.EmpDTO;

public class EmpInput {
	
	Scanner sc = null;

	public EmpInput() {
		sc = new Scanner(System.in);
		
	}
	
	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		
		System.out.println("사원 번호를 입력");
		int empno = sc.nextInt();
		empDTO.setEmpno(empno);
		
		System.out.println("사원 이름을 입력");
		String ename = sc.next();
		empDTO.setEname(ename);
		
		System.out.println("job을 입력");
		String job = sc.next();
		empDTO.setJob(job);
		
		System.out.println("mgr을 입력");
		int mgr = sc.nextInt();
		empDTO.setMgr(mgr);
		
		System.out.println("sal을 입력");
		int sal = sc.nextInt();
		empDTO.setSal(sal);
		
		System.out.println("comm을 입력");
		int comm = sc.nextInt();
		empDTO.setComm(comm);
		
		System.out.println("deptno을 입력");
		int deptno = sc.nextInt();
		empDTO.setDeptno(deptno);
		
		return empDTO;
	}
	
	//empnoInput
	//사원번호를 입력하세요
	
	public int empnoInput() {
		int empno = 0;
		System.out.println("사원 번호를 입력");
		empno = sc.nextInt(); 
		return empno;
		
	}
	

}

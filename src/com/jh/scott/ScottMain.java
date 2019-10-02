package com.jh.scott;

import com.jh.control.FrontController;
import com.jh.dept.DeptDAO;
import com.jh.dept.DeptDTO;

public class ScottMain {

	public static void main(String[] args) {

		FrontController frontController = new FrontController();
		frontController.start();


	/*	DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDeptno(98);
		deptDTO.setDname("Test");
		deptDTO.setLoc("Test");
		int result = deptDAO.deptInsert(deptDTO);
		System.out.println(result);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}



		eptController deptController = new DeptController();
		deptController.start();

		EmpDAO empDAO = new EmpDAO();
		EmpView ev = new EmpView();
		EmpDTO empDTO = empDAO.getSelectOne(7900);


		if(empDTO !=null) {
			ev.view(empDTO);
		}else {
			System.out.println("없는 번호 입니다.");
		}

		empDAO.getSelectList();

		DeptDAO dao = new DeptDAO();

		List<DeptDTO> ar =dao.deptSelectList();

		for(int i=0;i<ar.size();i++) {
			DeptDTO deptDTO = ar.get(i);
		} */
	}
}

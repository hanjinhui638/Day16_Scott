package com.jh.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jh.util.DBConnector;

public class EmpDAO {
	//getSelectList
	//전체사원정보 - 최신입사일순 
	public ArrayList<EmpDTO> getSelectList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>(); //size = 0 null
		
		try {
			con = DBConnector.getConnect();
			String sql = "select empno, ename, job, mgr, hiredate, sal, nvl(comm,0),deptno "
					+ "from emp order by hiredate desc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
				
				ar.add(empDTO);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} return ar;
		
		
	}
	
	//getSelectOne 
	//매개변수 사원번호
	
	public EmpDTO getSelectOne(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select* from emp "
					+ "where empno =?";
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			rs = st.executeQuery();
			
			if(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
					
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return empDTO;
		
		
	}
	
	

	
	
	
}

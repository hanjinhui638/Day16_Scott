package com.jh.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jh.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class EmpDAO {
	//%A% 
	//select*from emp
	//where ename like ?
	//st.setString(1, %A%)
	
	
	public void getSelectOne(String ename) {	//return 
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "select* from emp where ename like ? ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	public int delete(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con =DBConnector.getConnect();
			String sql = "delete emp where empno = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			result  = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empno;
	}

	public int empInsert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ "values (?,?,?,?,?,sysdate,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7, empDTO.getDeptno());

			result = st.executeUpdate();



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return result;

	}

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

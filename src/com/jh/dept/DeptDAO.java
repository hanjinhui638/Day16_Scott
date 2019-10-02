package com.jh.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jh.util.DBConnector;

public class DeptDAO {
	
	

	public int deptInsert(DeptDTO deptDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into dept (deptno, dname, loc) "
					+ "values(?,?,?) ";
			st = con.prepareStatement(sql);
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
		
			result = st.executeUpdate(); //성공 1, 실패0


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

		return result;

	}

	//selectList
	public List<DeptDTO> deptSelectList() {
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select* from dept order by deptno asc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));

				ar.add(deptDTO);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		}


		return ar;
	}


	//selectOne
	public DeptDTO deptSelectOne(int deptno) {
		DeptDTO deptDTO = null;
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select* from dept where deptno =? ";
			st = con.prepareStatement(sql);
			st.setInt(1, deptno);
			rs = st.executeQuery();

			if(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
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

		return deptDTO;
	}
}

package com.jh.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jh.util.DBConnector;



public class SalgradeDAO {

	public int saldelete(int grade){
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "delete salgrade where grade = ? ";
			st = con.prepareStatement(sql);
			st.setInt(1, grade);
			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return result;
	}	


	public int salInsert(SalgradeDTO salgradeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into sagrade (grade, losal, hisal) "
					+ "+values (?,?,?)";
			st= con.prepareStatement(sql);
			st.setInt(1, salgradeDTO.getGrade());
			st.setInt(2, salgradeDTO.getLosal());
			st.setInt(3, salgradeDTO.getHisal());

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

		} return result;


	}


	public ArrayList<SalgradeDTO> getSalectList() {
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "select grade, losal, hisal "
					+ "from salgrade";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				SalgradeDTO salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setHisal(rs.getInt("losal"));
				salgradeDTO.setLosal(rs.getInt("hisal"));

				ar.add(salgradeDTO);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return ar;


	}

	public SalgradeDTO getSalgradeOne(int grade) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		SalgradeDTO salgradeDTO = null;

		try {
			con = DBConnector.getConnect();
			String sql  = "select* from salgrade "
					+ "where grade = ? ";
			st = con.prepareStatement(sql);
			st.setInt(1, grade);
			rs = st.executeQuery();

			if(rs.next()) {
				salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setLosal(rs.getInt("losal"));
				salgradeDTO.setHisal(rs.getInt("hisal"));
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

		return salgradeDTO;


	}
}

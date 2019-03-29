package dao;

import entity.Stu_Tea;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Stu_TeaDAO {
	public void addRel(String snumber, String tnumber) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtils.getConn();
		String sql = "insert into stu_tea (snumber,tnumber) values(?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, snumber);
		pstmt.setString(2, tnumber);
		pstmt.executeUpdate();
		DBUtils.close(rs, pstmt, conn);
	}

	public List<Stu_Tea> findStu(String tnumber) throws Exception {
		List<Stu_Tea> stu_Teas = new ArrayList<Stu_Tea>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtils.getConn();
		String sql = "select * from stu_tea where tnumber=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, tnumber);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Stu_Tea st = new Stu_Tea();
			st.setId(rs.getInt("id"));
			st.setSnumber(rs.getString("snumber"));
			st.setTnumber(rs.getString("tnumber"));
			stu_Teas.add(st);
		}
		DBUtils.close(rs, pstmt, conn);
		return stu_Teas;
	}
	
	public void delStu_Rel(String snumber) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtils.getConn();
		String sql = "delete from stu_tea where snumber=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, snumber);
		pstmt.executeUpdate();
		DBUtils.close(null, pstmt, conn);
	}
	
	public void delTea_Rel(String tnumber) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtils.getConn();
		String sql = "delete from stu_tea where tnumber=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, tnumber);
		pstmt.executeUpdate();
		DBUtils.close(null, pstmt, conn);
	}

}

package dao;

import entity.Teacher;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 	DAO类:
 *    用于封装数据访问逻辑。
 */
public class TeacherDAO {
	
	/**
	 * 依据用户名tname查询该用户的所有信息，tname可替换
	 * 如果找不到，返回null。
	 * @throws Exception 
	 */
	public Teacher findTea(String tnumber) 
			throws Exception {
		Teacher tea = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement(
				"SELECT * FROM tea_info "
				+ "WHERE tnumber=?");
			stat.setString(1,tnumber);
			rst = stat.executeQuery();
			while(rst.next()) {
				tea = new Teacher();
				tea.setTid(rst.getInt(1));
				tea.setTnumber(tnumber);
				tea.setTname(rst.getString("tname"));
				tea.setGender(rst.getString("gender"));
				tea.setType(rst.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(rst, stat, conn);
		}
		return tea;
	}
	
	/**
	 * 删除指定参数的用户 暂时用参数tid 可替换
	 * @throws Exception 
	 */
	public void delete(String tnumber) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement(
				"DELETE FROM tea_info WHERE tnumber=?");
			stat.setString(1, tnumber);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(null, stat, conn);
		}
		
	}
	
	/**
	 * 将用户信息添加到数据库中(tea_info表)
	 * @throws Exception 
	 */
	public void save(Teacher tea) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement(
				"INSERT INTO tea_info "
				+ "VALUES(null,?,?,?,?,0)");
			stat.setString(1, tea.getTnumber());
			stat.setString(2, tea.getTname());
			stat.setString(3, tea.getGender());
			stat.setString(4, tea.getType());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	
	/**
	 * 将用户表(tea_info)中所有用户信息查询出来。
	 * @throws Exception 
	 */
	public List<Teacher> findAll() throws Exception{
		List<Teacher> teachers  = 
				new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement(
				"SELECT * FROM tea_info");
			rst = stat.executeQuery();
			while(rst.next()) {
				int tid = rst.getInt("tid");
				String tnumber = 
						rst.getString("tnumber");
				String tname = 
						rst.getString("tname");
				String gender = 
						rst.getString("gender");
				String type = 
						rst.getString("type");
				int count = rst.getInt("count");
				Teacher tea = new Teacher();	
				tea.setTid(tid);
				tea.setTnumber(tnumber);
				tea.setTname(tname);
				tea.setGender(gender);
				tea.setType(type);;
				tea.setCount(count);
				teachers.add(tea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(rst, stat, conn);
		}
		return teachers;
	}
	
	public List<Teacher> findPartTea(String type) throws Exception{
		List<Teacher> teachers  = 
				new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		conn=DBUtils.getConn();
		String sql="select * from tea_info where type=?";
		stat=conn.prepareStatement(sql);
		stat.setString(1, type);
		rst= stat.executeQuery();
		while(rst.next()) {
			Teacher tea=new Teacher();
			tea.setTid(rst.getInt("tid"));
			tea.setTnumber(rst.getString("tnumber"));
			tea.setTname(rst.getString("tname"));
			tea.setGender(rst.getString("gender"));
			tea.setType(rst.getString("type"));
			teachers.add(tea);
		}
		DBUtils.close(rst, stat, conn);
		return teachers;
	}
	
	public List<Teacher> findAllCourse() throws Exception{
		List<Teacher> teachers  = 
				new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		conn=DBUtils.getConn();
		String sql="select distinct type from tea_info ";
		stat=conn.prepareStatement(sql);
		rst= stat.executeQuery();
		while(rst.next()) {
			Teacher tea=new Teacher();
			tea.setType(rst.getString("type"));
			teachers.add(tea);
		}
		DBUtils.close(rst, stat, conn);
		return teachers;
	}
	
	public void update(Teacher tea) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql="update tea_info set tnumber=?,tname=?,gender=?,type=? where tnumber=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, tea.getTnumber());
			stat.setString(2, tea.getTname());
			stat.setString(3, tea.getGender());
			stat.setString(4, tea.getType());
			stat.setString(5, tea.getTnumber());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
}







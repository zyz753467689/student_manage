package dao;

import entity.Course;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CourseDAO {
	public Course find(String snumber) throws Exception {
		Course course=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rst=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("select * from Course where snumber=?");
			stat.setString(1,snumber);
			rst=stat.executeQuery();
			while(rst.next()) {
				course=new Course();
				course.setCid(rst.getInt(1));
				course.setCname(rst.getString("cname"));
				course.setTnumber(rst.getString("tnumber"));
				course.setSnumber(snumber);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rst, stat, conn);
		}
		return course;
	}
	
	public void delStu(String snumber) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("delete from Course where snumber=?");
			stat.setString(1, snumber);
			stat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	
	public void delTea(String tnumber) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("delete from Course where tnumber=?");
			stat.setString(1, tnumber);
			stat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	
	public void addCourse(String snumber,String tnumber,String course) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		conn=DBUtils.getConn();
		String sql="insert into course (cname,tnumber,snumber) values(?,?,?)";
		stat=conn.prepareStatement(sql);
		stat.setString(1, course);
		stat.setString(2, tnumber);
		stat.setString(3, snumber);
		stat.executeUpdate();
		DBUtils.close(null, stat, conn);
	}
}

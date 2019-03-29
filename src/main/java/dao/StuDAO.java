package dao;

import entity.Course;
import entity.Grade;
import entity.Stu_Info;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDAO {
	/**
	 * 该方法是根据学号snumber查询学生信息表中的所有信息
	 * 返回结果是一个集合
	 * @param snumber
	 * @return
	 * @throws Exception 
	 */
	public List<Stu_Info> findAll(String snumber)
			throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Stu_Info> list=new ArrayList<Stu_Info>();
		try {
			conn = DBUtils.getConn();
			stat=conn.prepareStatement(
					"select * from stu_info where snumber=?");
			stat.setString(1, snumber);
			rs=stat.executeQuery();
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String gender=rs.getString("gender");
				String age=rs.getString("age");
				String  profession=rs.getString("profession");
				Stu_Info stu=new Stu_Info();
				stu.setSid(sid);
				stu.setSnumber(snumber);
				stu.setSname(sname);
				stu.setGender(gender);
				stu.setAge(age);
				stu.setProfession(profession);
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}	
		return list;
	}

	/**
	 * 该方法是根据学号snumber查询学生信息表中的所有信息
	 * 返回结果是学生信息对象
	 * @param snumber
	 * @return
	 * @throws Exception 
	 */
	public Stu_Info find(String snumber)
			throws Exception {
		Stu_Info user=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConn();
			stat=conn.prepareStatement(
					"select * from stu_info where snumber=?");
			stat.setString(1, snumber);
			rs=stat.executeQuery();
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String gender=rs.getString("gender");
				String age=rs.getString("age");
				String  profession=rs.getString("profession");
				user=new Stu_Info();
				user.setSid(sid);
				user.setSnumber(snumber);
				user.setSname(sname);
				user.setGender(gender);
				user.setAge(age);
				user.setProfession(profession);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}
		return user;
	}

	/**
	 * 该方法是根据传入的学生信息对象，去修改
	 * 学生信息表中的学生个人信息
	 * 无返回结果
	 * @param user
	 * @throws Exception 
	 */
	public void updatestuinfo(Stu_Info user) 
			throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement(
					"update stu_info set sname=?,gender=?,age=?,profession=? where sid=?");
			stat.setString(1, user.getSname());
			stat.setString(2, user.getGender());
			stat.setString(3, user.getAge());
			stat.setString(4, user.getProfession());
			stat.setInt(5, user.getSid());
			stat.executeUpdate();
			System.out.println("数据修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}

	/**
	 * 该方法是根据传入学生学号，查询该学生的
	 * 所有科目的成绩
	 * 返回一个成绩对象的集合
	 * @param snumber
	 * @return
	 * @throws Exception 
	 */
	public List<Grade> findgrade(String snumber) throws Exception{
		List<Grade> users=new ArrayList<Grade>();	
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConn();
			stat=conn.prepareStatement(
					"select * from grade where snumber=?");
			stat.setString(1, snumber);
			rs=stat.executeQuery();
			while(rs.next()) {
				int gid=rs.getInt("gid");
				String course=rs.getString("course");
				int grade=rs.getInt("grade");
				Grade user=new Grade();
				user.setGid(gid);
				user.setSnumber(snumber);
				user.setCourse(course);
				user.setGrade(grade);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}	
		return users;
	}

	public List<Course> findcourse(String snumber) throws Exception{
		List<Course> cous=new ArrayList<Course>();
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConn();
			stat=conn.prepareStatement(
					"select * from course where snumber=?");
			stat.setString(1, snumber);
			rs=stat.executeQuery();
			while(rs.next()) {
				Course cou=new Course();
				cou.setCid(rs.getInt("cid"));
				cou.setCname(rs.getString("cname"));
				cou.setTnumber(rs.getString("tnumber"));
				cou.setSnumber(snumber);
				cous.add(cou);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}
		return cous;
	}
	/**
	 * 该方法是根据老师职工号查询教师姓名
	 * @param tnumber
	 * @return
	 * @throws Exception 
	 */
	public String findtname(String tnumber) throws Exception {
		String tname=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConn();
			stat=conn.prepareStatement(
					"select tname from tea_info where tnumber=?");
			stat.setString(1, tnumber);
			rs=stat.executeQuery();
			while(rs.next()) {
				tname=rs.getString("tname");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}
		return tname;
	}

}

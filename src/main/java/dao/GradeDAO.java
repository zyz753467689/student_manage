package dao;

import entity.Grade;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
	List<Grade>grades=new ArrayList<Grade>();
	public List<Grade> find() throws Exception {
		Grade grade=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rst=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("SELECT * FROM grade");
			rst=stat.executeQuery();
			while(rst.next()) {
				grade=new Grade();
				grade.setGid(rst.getInt("gid"));
				grade.setSnumber(rst.getString("snumber"));
				grade.setCourse(rst.getString("course"));
				grade.setGrade(rst.getInt("grade"));
				grades.add(grade);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rst, stat, conn);		
			}
		return grades;
	}
	
	//指定删除学号snumber的用户
	public void delete(String snumber) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("delete from Grade where snumber=?");
			stat.setString(1,snumber);
			stat.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();
		throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	public void save(Grade grade) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("insert into Grade values(null,?,?,?)");
			stat.setString(1,grade.getSnumber());
			stat.setInt(2,grade.getGrade());
			stat.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}	
	//根据snumber和grade 修改成绩
		public void update_grade(String snumber,String course,int grade) {
			Connection conn = null;
			PreparedStatement stat = null;
			try {
				conn = DBUtils.getConn();
				String sql = "update Grade set grade=? where snumber=? and course=?";
				stat = conn.prepareStatement(sql);
				stat.setInt(1, grade);
				stat.setString(2, snumber);
				stat.setString(3, course);
				stat.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(null, stat, conn);
			}
		}
		
		public void addGrade(String snumber,String course) {
			Connection conn = null;
			PreparedStatement stat = null;
			try {
				conn = DBUtils.getConn();
				String sql = "insert into Grade values(null,?,?,null)";
				stat=conn.prepareStatement(sql);
				stat.setString(1, snumber);
				stat.setString(2, course);
				stat.executeUpdate();
				DBUtils.close(null, stat, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(null, stat, conn);
			}
		}
		
		public Grade findOneCourse(String snumber,String course) {
			Connection conn = null;
			PreparedStatement stat = null;
			Grade grade=new Grade();
			ResultSet rs=null;
			try {
				conn = DBUtils.getConn();
				String sql = "select * from Grade where snumber=? and course=?";
				stat = conn.prepareStatement(sql);
				stat.setString(1, snumber);
				stat.setString(2, course);
				rs= stat.executeQuery();
				while(rs.next()) {
					grade.setGid(rs.getInt(1));
					grade.setSnumber(rs.getString("snumber"));
					grade.setCourse(rs.getString("course"));
					grade.setGrade(rs.getInt("grade"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(rs, stat, conn);
			}
			return grade;
		}
		
}
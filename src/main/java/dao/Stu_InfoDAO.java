package dao;

import entity.Stu_Info;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Stu_InfoDAO {
	//添加学生
		public void insert_stu(Stu_Info stu) {
			Connection conn=null;
			PreparedStatement stat=null;
			try {
				conn = DBUtils.getConn();
				String sql = "insert into Stu_info (snumber,sname,gender,age,profession) values(?,?,?,?,?)";
				stat = conn.prepareStatement(sql);
				stat.setString(1, stu.getSnumber());
				stat.setString(2, stu.getSname());
				stat.setString(3, stu.getGender());
				stat.setString(4, stu.getAge());
				stat.setString(5, stu.getProfession());
				stat.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(null, stat, conn);
			}
		}
		
		//查询所有学生
		public List<Stu_Info> findAll() {
			List<Stu_Info> stu_info = new ArrayList<Stu_Info>();
			Connection conn=null;
			PreparedStatement stat=null;
			ResultSet rst=null;
			try {
				conn = DBUtils.getConn();
				String sql = "select * from Stu_info";
				stat = conn.prepareStatement(sql);
				rst = stat.executeQuery();
				while(rst.next()) {
					Stu_Info stu = new Stu_Info();
					stu.setSid(rst.getInt("sid"));
					stu.setSnumber(rst.getString("snumber"));
					stu.setSname(rst.getString("sname"));
					stu.setGender(rst.getString("gender"));
					stu.setAge(rst.getString("age"));
					stu.setProfession(rst.getString("profession"));
					stu_info.add(stu);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.close(rst, stat, conn);
			}
			return stu_info;
		}
		
		//根据snumber查询学生
		public Stu_Info find(String snumber) throws Exception {
			Stu_Info stu_info=null;
			Connection conn=null;
			PreparedStatement stat=null;
			ResultSet rst=null;
			try {
				conn=DBUtils.getConn();
				stat=conn.prepareStatement("select * from Stu_info where snumber=?");
				stat.setString(1,snumber);
				rst=stat.executeQuery();
				while(rst.next()) {
					stu_info=new Stu_Info();
					stu_info.setSid(rst.getInt("sid"));
					stu_info.setSnumber(snumber);
					stu_info.setSname(rst.getString("sname"));
					stu_info.setGender(rst.getString("gender"));
					stu_info.setAge(rst.getString("age"));
					stu_info.setProfession(rst.getString("profession"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				DBUtils.close(rst, stat, conn);
			}
			return stu_info;
		}
		
		
		//根据sid查询学生
			public Stu_Info find(int sid) throws Exception {
				Stu_Info stu_info=null;
				Connection conn=null;
				PreparedStatement stat=null;
				ResultSet rst=null;
				try {
					conn=DBUtils.getConn();
					stat=conn.prepareStatement("select * from Stu_info where sid=?");
					stat.setInt(1,sid);
					rst=stat.executeQuery();
					while(rst.next()) {
						stu_info=new Stu_Info();
						stu_info.setSid(sid);
						stu_info.setSnumber(rst.getString("snumber"));
						stu_info.setSname(rst.getString("sname"));
						stu_info.setGender(rst.getString("gender"));
						stu_info.setAge(rst.getString("age"));
						stu_info.setProfession(rst.getString("profession"));
					}
				}catch (Exception e) {
					e.printStackTrace();
					throw e;
				}finally {
					DBUtils.close(rst, stat, conn);
				}
				return stu_info;
			}
	
	public void delete(String snumber) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("delete from Stu_info where snumber=?");
			stat.setString(1,snumber);
			stat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	public void save(Stu_Info stu_info) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement("insert into Grade values(null,?,?,?,?,?,?)");
			stat.setInt(1,stu_info.getSid());
			stat.setString(2,stu_info.getSnumber());
			stat.setString(3,stu_info.getSname());
			stat.setString(4,stu_info.getGender());
			stat.setString(5,stu_info.getAge());
			stat.setString(6,stu_info.getProfession());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, stat, conn);
		}
	}
	
	public Stu_Info findOneStu(String snumber) throws Exception {
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		Stu_Info stu=new Stu_Info();
		try {
			conn=DBUtils.getConn();
			String sql="select * from stu_info where snumber=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1, snumber);
			rs= stat.executeQuery();
			while(rs.next()) {
				stu.setSid(rs.getInt(1));
				stu.setSnumber(rs.getString("snumber"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getString("age"));
				stu.setGender(rs.getString("gender"));
				stu.setProfession(rs.getString("profession"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, stat, conn);
		}
		return stu;
	}
}

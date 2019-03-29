package dao;

import entity.Role;
import entity.User;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
	/**
	 * 根据用户名查询该用户的所有信息
	 * 查询出来的数据保存在user对象中，如果没有该用户
	 * 则返回的user对象为null
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public User find(String name) throws Exception {
		User user=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement(
			"select *from user where username=?");
			stat.setString(1, name);
			rs=stat.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRid(rs.getInt("rid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(rs, stat, conn);
		}
		return user;
	}
	
	public Role selectrole(int rid) throws Exception {
		Role role=null;
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConn();
			stat=conn.prepareStatement(
					"select rname from role where rid=?");
			stat.setInt(1, rid);
			rs=stat.executeQuery();
			while(rs.next()) {
				role=new Role();
				role.setRid(rid);
				role.setRname(rs.getString("rname"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}	
		return role;
	}
}

package dao;

import entity.User;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<User> users=new ArrayList<User>();
	
	public User findone(String username) throws Exception {
		conn= DBUtils.getConn();
		User user=null;
		String sql="select * from user where username=?"; 
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setUid(rs.getInt(1));
			user.setUsername(username);
			user.setPassword(rs.getString(3));
		}
		return user;
	}
	
	public List<User> findAll() throws Exception {
		conn= DBUtils.getConn();
		String sql="select * from user"; 
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			String username=rs.getString(2);
			String password=rs.getString(3);
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			users.add(user);
		}
		DBUtils.close(rs, pstmt, conn);
		return users;
	}
	
	public void addUser(String name,String pwd,int rid) throws Exception {
		conn=DBUtils.getConn();
		String sql="insert into user values(null,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		pstmt.setInt(3, rid);
		pstmt.executeUpdate();
		DBUtils.close(rs, pstmt, conn);
	}
	
	public void delUser(String username) throws Exception {
		conn=DBUtils.getConn();
		String sql="delete from user where username=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.executeUpdate();
		DBUtils.close(rs, pstmt, conn);
	}
	
}

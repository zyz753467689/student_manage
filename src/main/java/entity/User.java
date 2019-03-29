package entity;

public class User {
	private int uid;
	private String username;
	private String password;
	private int rid;
	
	public User() {
		super();
	}
	public User(int uid, String username, String password, int rid) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", rid=" + rid + "]";
	}
	
}

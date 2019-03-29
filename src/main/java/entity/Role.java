package entity;

public class Role {
	private int rid;
	private String rname;
	
	public Role(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + "]";
	}
	
}

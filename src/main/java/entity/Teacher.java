package entity;

public class Teacher {
	private int tid;
	private String tnumber;
	private int count;
	private String tname;
	private String gender;
	private String type;
	
	public Teacher() {
		super();
	}
	public Teacher(int tid, String tnumber, int count, String tname, String gender, String type) {
		super();
		this.tid = tid;
		this.tnumber = tnumber;
		this.count = count;
		this.tname = tname;
		this.gender = gender;
		this.type = type;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tnumber=" + tnumber + ", count=" + count + ", tname=" + tname + ", gender="
				+ gender + ", type=" + type + "]";
	}
}

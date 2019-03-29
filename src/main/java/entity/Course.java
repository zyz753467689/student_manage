package entity;
/**
 * 课程表实体类
 * @author soft01
 *
 */
public class Course {
	private int cid;//课程编号
	private String cname;//课程名称
	private String tnumber;//教师职工号
	private String snumber;//学生学号
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", tnumber=" + tnumber + ", snumber=" + snumber + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
	
}

package entity;
public class Stu_Info {
	private int sid;
	private String snumber;
	private String sname;
	private String gender;
	private String age;
	private String profession;

	@Override
	public String toString() {
		return "User3 [sid=" + sid + ", snumber=" + snumber + ", sname=" + sname + ", gender=" + gender + ", age=" + age
				+ ", profession=" + profession + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
}
package entity;

public class Grade {
	private int gid;//成绩编号
	private String snumber;//学生学号
	private String course;//课程名
	private int grade;//成绩
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", snumber=" + snumber + ", course=" + course + ", grade=" + grade + "]";
	}
	
}

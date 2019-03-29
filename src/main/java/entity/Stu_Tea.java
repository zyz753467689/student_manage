package entity;

public class Stu_Tea {
	private int id;
	private String snumber;
	private String tnumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	@Override
	public String toString() {
		return "Stu_Tea [id=" + id + ", snumber=" + snumber + ", tnumber=" + tnumber + "]";
	}
	
}

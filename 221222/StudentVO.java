package jdbc2;

// 멤버변수 : private
// 외부에서는 setter/getter로 접근
public class StudentVO {
	
	private String id;
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	
	// static Test
	static String country = "Korea";
	
	// 생성자 메서드
	public StudentVO() {
		System.out.println("** default 생성자 **");
	}
	
	// 모든 컬럼 초기화하는 생성자
	public StudentVO(String id, String name, int age, int jno, String info, double point, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.jno = jno;
		this.info = info;
		this.point = point;
		this.birthday = birthday;
	}

	public String getId() { return id;} // 내보내기
	public void setId(String id) { this.id=id;} // 입력받기
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + "]";
	}
	
} // class
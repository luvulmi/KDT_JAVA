package vo;

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table 별로 만들며, Table 과 동일한 필드명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO 라 함.

//=> 멤버변수 : private
//=>외부에서는 setter/getter 로 접근
public class StudentrVO {
	private String id;
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	
	// ** 생성자
	// => class명과 이름동일, return값 (void포함) 없음
	// => default 생성자
	//	  -> 생성자가 없으면 컴파일러가 자동생성
	//	  -> 매개변수가 없음
	//	  -> 생성자를 1개라도 작성하면 자동생성은 안됨
	
	public StudentrVO() {
		System.out.println("** default 생성자 **");
	} // => 모든 칼럼을 초기화하는 생성자
	
	
	// => 모든 컬럼을 초기화 하는 생성자
	public StudentrVO(String id, String name, int age, int jno, String info, double point, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.jno = jno;
		this.info = info;
		this.point = point;
		this.birthday = birthday;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "StudentrVO [id=" + id + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + "]";
	}

}// class

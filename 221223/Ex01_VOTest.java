package jdbc02;

//** VO class 활용 정리

public class Ex01_VOTest {
	public static void main(String[] args) {
		// 1. 초기화
		// => 생성자 : 생성 시 1회만 사용가능.
		// 중요자료 보호하는 경우 생성자로 초기화 하고, setter 제공하지 않음(수정불가)
		StudentVO vo1 = new StudentVO("banana","딸기",22,9,"생성자 초기화",123.45,"2001-10-10");
		System.out.println("** vo1 id => " + vo1.getId());
		System.out.println("** vo1 name => " + vo1.getName());
		
		// => setter : 언제든 호출 가능.
		StudentVO vo2 = new StudentVO();
		vo2.setId("apple");
		vo2.setName("김사과");
		vo2.setAge(27);
		vo2.setJno(7);
		vo2.setInfo("setter로 초기화");
		vo2.setPoint(300.55);
		vo2.setBirthday("1996-09-09") ;
		System.out.println("** vo2 id => " + vo2.getId());
		System.out.println("** vo2 name => " + vo2.getName());
		
		vo2.country = "USA";
		System.out.println("** vo2 country => "+ vo2.country);
		System.out.println("** vo2 country => "+ vo1.country);
		
		// 2. 확인 & 출력 
		// => getter / toString()
		System.out.println("** vo1 toString => "+ vo1.toString());
		System.out.println("** vo2 toString => "+ vo2.toString());
		
		// toString() : Object에 정의되어, 인스턴스 생성시 주소값을 String Type으로 return.
		//			  : 출력문에서 호출 시 메서드명 생략 가능.
		// 			  : 출력문에서 인스턴스명을 사용하면 toString() 메서드 자동 호출.
		Ex01_VOTest ex01 = new Ex01_VOTest();
		System.out.println("** Ex01 toString => "+ ex01.toString());
		System.out.println("** Ex01 toString 생략 => "+ ex01);
		System.out.println("** vo1 toString 생략 => "+ vo1);
		System.out.println("** vo2 toString 생략 => "+ vo2);
		
		// 3. static 맴버
		// => 인스턴스로 접근하는 의미가없음, 클래스명으로 접근하도록함  
		// => 바람직하지는 않으나 오류는 나지 않음
		System.out.println("** vo1 country => "+ vo1.country);
		
	} // main
} // class
class Car {
	CarName name;
	String color;

	Car(String aModel, int aYear, String aColor) {
		name = new CarName(aModel, aYear); // 이너클래스에 해당 하는 변수.
		color = aColor;
	}

	
	class CarName {
		String model;
		int year;

		CarName(String aModel, int aYear) {
			model = aModel;
			year = aYear;
		}

		void outSubInfo() {
			System.out.printf("서브 클래스 직접참조 : 모델=%s, 년식=%d\n", model, year);
			System.out.printf("주 클래스 간접참조 : 모델=%s, 년식=%d\n", name.model, name.year);
		}
	}
	
	// 이너 클래스 내부에서 이너 클래스 필드 참조는 내부 직접 참조와 주 클래스 통한 간접참조로 나누어짐.
	// 외부 객체  생성 시 참조 주체가 주 클래스 객체인지 이너 클래스 객체인지 따라 달라짐.
	// 참조 주체 : 주클래스 객체인 경우, 이너 클래스 객체 자체가 주클래스 생성자에 종속되어 생성되므로
	// 이너 클래스 내부 필드 직접참조 = 주 클래스의 간접참조 동일 대상 가리킴.
	// 참조 주체 : 외부 생성 이너 클래스 객체인 경우, 주 클래스 객체에 종속되어 생성
	// -> 주 클래스 모든 멤버 직접 참조 가능. 이너 클래스 내부 필드 직접참조 != 주 클래스의 간접참조 다름.
	

}

public class Main {
	public static void main(String[] args) {
		Car pride = new Car("프라이드",2005, "파랑");
		Car.CarName pride2 = pride.new CarName("프랑이",2009);
		
		pride.name.outSubInfo(); // 주 클래스 객체 내부 생성된 이너 클래스 타입 멤버 메서드.
								 // 참조 주체 : 주클래스 객체.
		System.out.println();
		
		pride2.outSubInfo();	// 참조 주체: 외부 생성 이너 클래스 객체.
								// 주객체에 의존적. 내부적으로 주객체 모든 멤버와 동등한 자격.
								// 아무런 제약없이 주 클래스 객체 멤버에 접근가능.
								// 간접적으로 주 객체 멤버까지도 참조 가능.

	}

}

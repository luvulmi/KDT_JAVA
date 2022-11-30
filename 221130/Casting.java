class CarName1 {
	String model;
	int year;
	
	CarName1(String a, int aYear) {
		model =a;
		year = aYear;
	}
}

class Car2 {
	CarName1 name;	// 클래스의 멤버 클래스.
	String color;
	
	Car2(String amodel, int ayear, String acolor){
		name = new CarName1(amodel,ayear);	// 외부 클래스 멤버 사용 위한 객체 생성.
		color = acolor;
	}
	
	void outInfo() {
		System.out.printf("모델 %s, 년식=%d, 색상=%s\n", name.model, name.year, color);
	}
}


public class Casting {
	public static void main(String[] args) {
		Car2 pride = new Car2("프라이드", 2009, "보라");
		pride.outInfo();
		
		CarName1 gran = new CarName1("그랜다이져", 2016); // 별도의 객체.
		System.out.printf("모델 %s, 년식=%d\n", gran.model, gran.year);
		
		pride.outInfo();
	}

}
class Car {
	String name;
	String color;
	
	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}
}

class OverridingCar {
	String name;
	String color;
	
	public OverridingCar(String name, String color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OverridingCar) { // 주 객체와 전혀 관련없는 객체 대입에 따른 예외 발생 방지하기 위해 
										   // instanceof 연산자를 활용한 방어코드 설정.
			OverridingCar tObj = (OverridingCar)obj;
			return name.equals(tObj.name) && color.equals(tObj.color);
		}
		return false;
	}
}

public class JAVA1207_6 {
	public static void main(String[] args) {
		OverridingCar sonata = new OverridingCar("소나타", "검정");
		OverridingCar sonata2 = new OverridingCar("소나타", "검정");
		OverridingCar sonata3= new OverridingCar("소나타", "검정2");
		
		Car sonata4 = new Car("소나타","검정");
		
		System.out.printf("sonata와 sonata2는 %s\n", sonata.equals(sonata2) ? "같다" : "다르다");
		System.out.printf("sonata와 sonata3는 %s\n", sonata2.equals(sonata3) ? "같다" : "다르다");
		System.out.printf("sonata와 sonata4는 %s\n", sonata.equals(sonata4) ? "같다" : "다르다");
			
	}
}

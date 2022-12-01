abstract class Dog {
	void swingTail() {
		System.out.println("살랑살랑");
	}
	
	abstract void bark();
}

class Jindo extends Dog{
	void bark() {
		System.out.println("멍멍");
	}
}

class Siba extends Dog{
	void bark() {
		System.out.println("왈왈");
	}
}

public class Main1201_1 {
	public static void main(String[] args) {
		Jindo jindol = new Jindo();
		Siba baba = new Siba();
		
		jindol.swingTail();
		baba.bark();
		System.out.println();
		
		dogcafe(jindol);
		dogcafe(baba);
		
	}
	
	static void dogcafe(Dog dog) { // 슈퍼타입 변수로 서브타입 객체 대입받아 슈퍼타입 변수 메서드를 호출함에도
		dog.bark();				   // 동적 바인딩에 의한 실 객체 재정의 메서드가 정상적으로 호출됨 확인 가능. 
	}							   // 추상 클래스 목적은 공통 요소를 묶어 확장된 파생타입 객체 생성을 위한 다형성 확보.
}

interface Animal { // 추상메서드만 멤버로 포함 가능함.
	void eat();

	void sleep();
}

abstract class Dog1 {
	void swingTail() {
		System.out.println("살랑살랑");
	}

	abstract void bark();
}

class Chiwawa extends Dog1 implements Animal {
	void bark() {
		System.out.println("왈왈");
	}
	
	public void eat() {
		System.out.println("우걱우걱");
	}

	public void sleep() {
		System.out.println("쿨쿨");
	}
}

public class Inter {
	public static void main(String[] args) {
		Chiwawa happy = new Chiwawa();
		
		happy.swingTail();
		happy.bark();
		happy.eat();
		happy.sleep();
		System.out.println();
		
		Animal dog = new Chiwawa();
		// 인터페이스는 구현을 가지지 않음으로 객체 생성 불가.
		// 인터페이스 타입의 변수 선언은 가능. -> 이를 통해 서브타입 구현 객체를 대입 받아 동적 바인딩 가능.
		
		dog.eat();
		dog.sleep();
		((Chiwawa)dog).bark();
		// 인터페이스 타입 animal변수로 구현된 서브 객체 chiwawa를 가리켰으므로
		// 상속 규칙에 의해 eat()과 sleep() 메서드는 직접 호출 가능.
		// Dog 클래스로부터 상속 및 재정의된 추상메서드를 호출하기 위해 chiwawa 타입으로 하향 캐스팅.
		// 슈퍼타입 변수로 서브 타입 객체를 가리켰을 때 서브의 재정의 메서드는 직접 호출이 가능하지만
		// 추가 메서드는 하향 캐스팅을 통해 호출 가능함.
		
	}

}


interface FunctionalInterface {
	String str = "함수형 인터페이스";

	void testThis();
}

class SuperClass {
	String str = "부모";

	public void testThis() {
	}
}

class MainClass extends SuperClass {
	String str = "주 클래스";

	public void testAnonymousThis() {
		SuperClass t = new SuperClass() {
			String str = "익명 객체";

			@Override
			public void testThis() {
				System.out.println("익명 객체의 this : " + this.str); // 익명 객체에서의 this 는 기본적으로 자식이 되는 익명 객체 자기 자신을
				System.out.println("익명 객체 내에서 멤버 참조 : " + str); // 익명 객체 내에서는 부모의 멤버와 명칭이 겹치지 않는 이상 this 를
				System.out.println("주 클래스의 this : " + MainClass.this.str); // 부모가 아닌 익명 객체가 생성되는 주 클래스(MainClass)를
				// 가리키는 경우에는 당행과 같이 주클래스명을 통해 this 를 참조.
				System.out.println();
			}
		};

		t.testThis();
	}

	public void testLambdaThis() {
		FunctionalInterface t = () -> {
			System.out.println("람다식에서의 this : " + this.str); // 람다식 내에서의 this 또한 람다 객체 자기 자신을 의미하는 것은 아니나, 익명
			// 객체와 같이 부모를 가리키는 것은 아니며 람다식을 구현하는 주 클래스(MainClass)를
			// 의미.

			System.out.println("람다식 내에서 멤버 참조 : " + str); // 람다식 내에서의 멤버 참조는 기본적으로 주 클래스의 멤버를 참조.
		};

		t.testThis();
	}
}

public class Lamda {
	public static void main(String[] args) {
		new MainClass().testAnonymousThis();
		new MainClass().testLambdaThis();

	}

}

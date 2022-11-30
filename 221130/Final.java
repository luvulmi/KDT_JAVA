// 상속이 금지되는 단말 클래스.
final class SuperClass1 {
	void out() {
		System.out.println("final 클래스");
	}
}

// final 클래스 : 서브 클래스 생성 불가.
//class SubClass extends SuperClass1 {
//	void out() {
//		System.out.println("서브 클래스");
//	}
//}


// final 메서드 : 상속은 되나 재정의(오버라이딩) 금지.
// 슈퍼 클래스 메서드에 대한 private 지정은 서브클래스 상속O 재정의O 접근X.
// final 지정은 마찬가지로 상속O 접근O 재정의X.
class SuperClass2 {
	final void out() {
		System.out.println("final 메서드");
	}
}

class SubClass2 extends SuperClass2 {
//	void out() {
//		System.out.println("메서드 재정의");
//	}
}

public class Final {
	public static void main(String[] args) {
		SubClass2 sub = new SubClass2();
		
		sub.out();
	}
}

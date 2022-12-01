interface Func {	// 공통 인터페이스.
	void func1();
	void func2();
}


class ImpleClass1 implements Func{
	@Override
	public void func1() {
		System.out.println("구현1");
	}

	@Override
	public void func2() {
		System.out.println("구현2");
	}
}

class ImpleClass2 implements Func{
	@Override
	public void func1() {
		System.out.println("구현3");
	}

	@Override
	public void func2() {
		System.out.println("구현4");
	}
}

public class Inter2 {
	public static void main(String[] args) {
		// 공통 인터페이스 타입변수에 대해 개별 구현 객체를 대입.
		// 객체별 공통 기능에 대한 세부적 다형성 확보.
		Func f1 = new ImpleClass1();
		Func f2 = new ImpleClass2();
		
		f1.func1();
		f1.func2();
		
		f2.func1();
		f2.func2();
	}

}

interface Super {
	void superMethod();
}

// 서브 인터페이스가 구현을 할 수는 없으므로(추상 메서드는 구현 불가)
// 슈퍼 인터페이스로부터 상속.

interface Sub1 extends Super { // 인터페이스 간에는 구현(implements)이 아닌, 상속(extends).
	void sub1_Method();
}

interface Sub2 extends Super {
	void sub2_Method();
}

class ImpleObj implements Sub1, Sub2 {

	@Override
	public void superMethod() {
		System.out.println("슈퍼 인터페이스의 추상메서드");
	}

	@Override
	public void sub2_Method() {
		System.out.println("서브2 인터페이스의 추상메서드");
	}

	@Override
	public void sub1_Method() {
		System.out.println("서브1 인터페이스의 추상메서드");
	}	
}

public class Interface1202_1 {
	public static void main(String[] args) {
		// 인터페이스 타입 변수 = 클래스 객체와 대입
		Super superObj = new ImpleObj();
		Sub1 sub1_Obj = new ImpleObj();
		Sub2 sub2_Obj = new ImpleObj();
		
		superObj.superMethod();
		System.out.println();
		
		sub1_Obj.superMethod();
		sub1_Obj.sub1_Method();
		System.out.println();
		
		sub2_Obj.superMethod();
		sub2_Obj.sub2_Method();
		
	}

}

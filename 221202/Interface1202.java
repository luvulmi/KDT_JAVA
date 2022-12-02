interface defaultType {
	class InnerClass {
		public void test() {	// 인터페이스 내 이너 클래스나 이너 인터페이스는
								// 기본적으로 public static 적용. 공개 정적 타입으로 구현.
			System.out.println("인터 페이스 내 이너 클래스");
		}
	}
	
	interface InnerInterface {
		void test();
	}
}
public class Interface1202 {
	public static void main(String[] args) {
		new defaultType.InnerClass().test();
		
		new defaultType.InnerInterface() {
			
			@Override
			public void test() {
				System.out.println("인터페이스 내 이너 인터페이스");
			}
		}.test();
		
	}
}

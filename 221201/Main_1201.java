class AA {
	int h = 3;
	BB b = new BB();

	AA() {
//		i = 1;		// 주 클래스에서는 이너 클래스 멤버 직접 참조 불가.
//		j = 1;
//		k = 1;
		b.i = 5; // 주 클래스 내부적으로 이너 클래스 객체를 생성한 후
		b.c.j = 7; // 그 후 그 객체를 통해 이너 클래스 내부 필드 접근 가능.
		b.c.d.k = 9;
	}

	class BB {
		int i;
		CC c = new CC();

		class CC {
			int j;
			DD d = new DD();

			class DD {
				int k;

				/*
				 * 이너 클래스 다중 중첩을 하여도 이너 클래스 내부에서는 외부 주 클래스 모든 멤버 제한없이 직접 접근 가능.
				 */
				void inner() {
					System.out.printf("h=%d, i=%d, j=%d, k=%d\n", h, i, j, k);
				}
			}
		}
	}

	public void outer() {
		b.c.d.inner();
		// 이너 클래스들에 대한 private 지정으로 인해 외부에서 주클래스 객체를 통해 직접 접근 불가하므로
		// 이너 클래스 내부 메서드 호출 위해 주클래스 메서드 설정해주어야함.
	}
}

public class Main_1201 {
	public static void main(String[] args) {
		AA a = new AA();

		a.b.c.d.inner(); // 이너 클래스 private 지정으로 인한 외부 직접 접근 불가.
		a.outer();

		AA.BB b = a.new BB(); // 이너 클래스 private 지정으로 인한 외부 객체 생성 불가.

	}

}

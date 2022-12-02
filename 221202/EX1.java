interface Check {
	boolean agetest(int a);
}

public class EX1 {
	public static void checkAge(int[] age, Check a) {
		for (int i : age) {
			if (a.agetest(i)) { // 조건으로 받을 메서드 구현 -> return 값이 boolean이어야함.
				System.out.println(i);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] age = new int[] { 43, 19, 27, 15, 36 };
		checkAge(age, b -> b > 20); // 람다식의 인수 -> 슈퍼가 되는 인터페이스 타입의 변수로 받아야함.
		checkAge(age, c -> c < 20);
	}
}

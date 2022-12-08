import java.util.Random;

public class JAVA1208_9 {
	public static void main(String[] args) {
		double n = Math.random(); // Math : 자바의 기본 내장API클래스로 임포트 불필요.
								 // double random() : 0 <= ~ < 1 범위의 실수 난수 발생.
		
		System.out.println(n);
		System.out.println((int)(n*10)); // 0 <= ~ <= 9 정수 범위 난수로 가공.
		System.out.println((int)(n*100)); // 0 <= ~ <= 99 정수 범위 난수로 가공.
		System.out.println();
		
		Random n1 = new Random();
		
		System.out.println(n1.nextInt()); // int형 범위 내 정수 난수 발생(음수 포함).
		System.out.println(n1.nextInt(10)); // 해당 인수 범위의 난수 발생.
		System.out.println();
	}

}

import java.util.Iterator;

// 람다식 참조는 함수형 인터페이스만 가능.
//class Abs {
//	int extract(int i);
//}

// 함수형 인터페이스 애노테이션: 함수형 인터페이스임을 명시적으로 표현함으로써 하나의 추상 메서드만 정의하도록 강제.
// 단, 디폴트와 정적 메서드 추가는 가능.

interface Abs {
	int extract(int i);
	
//	double extract2(double i);
}


public class Funcinterface {

	public static void get(int[] data, Abs abs) {
		for (int i : data) {
			System.out.println(abs.extract(i));
		}
	}
	public static void main(String[] args) {
		int[] data = { 7, -3, 9, -1, 6};
		
		get(data, i -> (i >= 0)? i : -i);
		
	}

}

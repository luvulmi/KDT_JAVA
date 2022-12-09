import java.util.Iterator;
import java.util.LinkedList;

class GenericBox<T> { // 제네릭 타입이 클래스 선연 => "플래스명<형식인수 타임>"
	T value;
	int temp = 5; // 제네릭은 형식인수가 실인수로 대체되는 일종의 매크로 타입일뿐 클래스 내에서
					// 무조건 제네릭 타입만 써야하는 것은 아니며 다른 타입의 사용도 가능.

	GenericBox(T value) {
		this.value = value;
	}

	T get() {
		return value;
	}

	void set(T value) {
		this.value = value;
	}
}

public class JAVA1209_4 {
	public static void main(String[] args) {

		GenericBox<Integer> intBox = new GenericBox<Integer>(1234); 
		int t1 = intBox.get(); // 제네릭 타입 설정으로 인해 캐스팅이 필요치 않으며 16행과 같이 타입 불일치 시 바로 컴파일
		System.out.println(t1); // 에러 처리되어 타입 안정성 확보. 일반적인 참조형의 경우 기본형과의 상호 직접 대입이 불가능하나
// 래퍼클래스의 경우 예외적으로 오토박싱이 수행되어 상호 직접 대입 가능.

		GenericBox<Double> dblBox = new GenericBox<Double>(12.34);
		double t2 = dblBox.get();
		System.out.println(t2);

	}

}

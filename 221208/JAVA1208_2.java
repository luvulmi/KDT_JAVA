class Car {
	String name;
	Car(String name){ this.name=name;}
}

public class JAVA1208_2 {
	public static void main(String[] args) {
		Car sonata = new Car("소나타"); // 힙 영역에 string 객체 생성.
		Car sonata2 = new Car("소나타");
		String cat = new String("고양이");
		String cat2 = new String("고양이");
		String cat3 = "고양이"; // pool 영역에 문자열들을 비교하여 존재한다면 그 문자열에 대한 참조값을 반환
		String cat4 = "고양이"; // 그렇지 않다면 새로운 영역에 해당 문자열 생성.
							  // 리터럴로 문자열 생성하거나 intern() 메서드 활용 시 메모리 절약 가능하나 비교연산 시간 소요.
		
		String cat5 = new String("고양이").intern(); // intern() 메서드 통해 pool영역 검색하여 참조값 리턴.
		String cat6 = cat5.intern();
		
		String cat7 = String.valueOf(cat6); // 래퍼 클래스 valurOf 메서드 기능과 상이. 인수객체의 문자열 리터럴 값 리턴.
		
		
		System.out.println(sonata == sonata2);
		System.out.println(sonata.equals(sonata2));
		System.out.println();
		
		// equal 메서드는 참조값이 아닌 문자열 내용으로 평가됨.
		System.out.println(cat == cat2);
		System.out.println(cat.equals(cat2));
		System.out.println();
		
		System.out.println(cat3==cat4);
		System.out.println(cat3.equals(cat4));
		System.out.println();
		
		System.out.println(cat==cat3);
		System.out.println(cat.equals(cat3));
		System.out.println();
		
		System.out.println(cat3==cat5);
		System.out.println(cat3.equals(cat5));
		System.out.println(cat3==cat6);
		
		System.out.println(cat3==cat7);
		System.out.println(cat3==cat.intern());
		System.out.println();
		
		String cat8 = "고"+"양이";
		System.out.println(cat3==cat8);
		
		// 최초 할당 후 기존영역에 재할당은 불가.
		String cat9 = "고";
		cat9+="양이";
		System.out.println(cat3==cat9);
		
	}

}

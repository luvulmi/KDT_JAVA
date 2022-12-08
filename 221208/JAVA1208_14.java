import java.util.ArrayList;

public class JAVA1208_14 {
	public static void main(String[] args) {
		ArrayList<String> arName = new ArrayList<String>(); // 디폴트 생성자 : 크기 10 용량으로 설정.
		ArrayList<String> arName1 = new ArrayList<String>(5); // 5크기 용량 설정.
		
		arName.add("A");
		arName.add("C");
		arName.add("D");
		// Add(E e) : 해당 컬렉션에 요소 추가. 인수의 타입이 일치해야함.
		
		arName1.add("A");
		arName1.add("B");
		arName1.add("C");
		arName1.add("D");
		
		System.out.println(arName.size()); // size() : 배열리스트에 저장되어 있는 전체 요소의 수 리턴.
		System.out.println(arName1.size());
		System.out.println();
		
		for (int i = 0; i < arName.size(); i++) {
			System.out.print(arName.get(i)+" "); // get(int index) : 해당 인덱스 위치의 요소값 리턴
		}
		System.out.println('\n');
		
		for (String s : arName1) { // foreach문 형식 또한 지원.
			System.out.print(s+ " ");
		}
		System.out.println('\n');
		
		System.out.println(arName1.toString()); // tostring() 통해 전체 요소값 리턴 가능.
		System.out.println();
		
		arName.add("E"); // 데이터 추가 시 자동으로 맨 끝 요소 다음에 추가
		System.out.println(arName1.toString());
		System.out.println();
		
		arName.add(1, "B"); // add(int index, E e) : 해당 인덱스 위치에 요소값 추가 삽입. 삽입 이후 값이 밀려나 내부적으로 복사가 진행.
							// ArrayList의 경우 자료 추가 시 처리 속도면에서 불리.
		System.out.println(arName.toString());
	}
}

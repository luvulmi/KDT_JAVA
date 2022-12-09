import java.util.ArrayList;

public class JAVA1209_1 {
	public static void main(String[] args) {
		ArrayList<String> arName = new ArrayList<String>();
		
		arName.add("A");
		arName.add("B");
		arName.add("C");
		arName.add("D");
		arName.add("E");
		arName.add("F");
		arName.add("B");
		arName.add("G");
		
		System.out.println(arName.isEmpty()); // isEmpty() : 배열이 비었는지 확인.
		
		arName.set(1, "C"); // set(index, element) : 해당 인덱스 위치 요소 값 변경.
		System.out.println(arName.toString());
		
		System.out.println(arName.indexOf("X")); // indexOf(object) : 전달된 인수 객체와 일치하는 배열 요소 인덱스 리턴.
		System.out.println(arName.indexOf("B")); // 존재하지 않으면 -1. 순차 검색.
		System.out.println(arName.lastIndexOf("B")); // lastindexOf(object) : 역순 검색.
		
		arName.remove(arName.lastIndexOf("B")); // remove(index) : 해당 인덱스 위치 요소 값 삭제.
		System.out.println(arName.toString());
		
		arName.clear(); // clear() : 모든 요소값 삭제.
		System.out.println(arName.toString()); 
		
		System.out.println(arName.isEmpty());
	}

}

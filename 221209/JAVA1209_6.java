import java.util.HashSet;
import java.util.Iterator;

public class JAVA1209_6 {
	public static void main(String[] args) {
		HashSet<String> figure = new HashSet<String>();

		figure.add("사각형");
		figure.add("오각형");
		figure.add("원형");
		figure.add("삼각형");

		Iterator<String> el1 = figure.iterator();

		while (el1.hasNext()) { // 반복자를 통한 집합 순회.
			System.out.print(el1.next() + " ");
		}
		System.out.println();

		for (String el2 : figure) { // foreach문을 이용한 집합 순회.
			System.out.print(el2 + " ");
		}
		System.out.println();

		System.out.println(figure.add("육각형")); // add : 저장하려는 데이터가 중복되지 않으면 집합에 데이터 저장하고 true 리턴.
		System.out.println(figure.add("삼각형")); // 데이터가 중복되면 false 리턴.

		System.out.println(figure.contains("오각형")); // contains : 데이터 포함 여부 반환.
		System.out.println();

		// HashSet > 필터링 기능.
		int[] data = {1, 2, 1, 3, 4, 5, 1};
		HashSet<Integer> set = new HashSet<>();
		
		for(int i : data) {
			set.add(i);
		}
		System.out.println(set);
		
		Integer[] ar = set.toArray(new Integer[0]); // 배열크기 0으로 지정하면 요소 크기 맞춰 자동 할당.
				
		for (Integer i : ar) {
			System.out.println(i);
		}
		
		

	}

}

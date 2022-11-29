class Storage2 {
	int[] storage = new int[10]; // 초기값 0.
	int cnt = 0;
	int currentCnt = 0;
	
	void store(int... s) {
		System.out.print("\n저장대상 :");
		for (int i : s) {
			System.out.printf(" %d",i);
		}
		System.out.println();
		if(s.length < storage.length - currentCnt) {
			for (int i = currentCnt; i < s.length + currentCnt; i++) {
				storage[i] = s[i - currentCnt];
				cnt++;
			}
			currentCnt = cnt;
			System.out.printf("남은 공간은 %d개 입니다.\n", storage.length - currentCnt);
			for(int j : storage) {
				System.out.printf(" %d",j);
			}
		} else {
			System.out.println("저장불가 : 저장공간 꽉참.");
		}
	}
	
	// 후위 검색
	void drop(int... d) {
		System.out.print("삭제대상 :");
		for (int i : d) {
			System.out.printf(" %d",i);
//			if (d.contains(i))
		}
		
		
		// 만약 배열에 해당 값이 존재한다면
		// 배열에서 해당 값 삭제.
		// 존재하지 않는다면
		// 삭제하려는 데이터 존재x 출력.
		
		System.out.println();
		for(int i : storage) {
//			System.out.printf("남은 공간은 %d입니다.",i의 갯수);
			System.out.printf(" %d",i);
		}
	}
	
}


public class ex3 {
	public static void main(String[] args) {
		Storage2 First = new Storage2();
		
		First.drop(5,1);
		First.store(5,1,3);
		
		
		
		
		
	}

}

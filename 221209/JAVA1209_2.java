import java.util.ArrayList;
import java.util.LinkedList;

public class JAVA1209_2 {
	public static void main(String[] args) {
		ArrayList<String> arList = new ArrayList<String>();
		LinkedList<String> lkList = new LinkedList<String>();
		
		long start = System.currentTimeMillis(); // 현재까지 경과한 시간 1000분의 1초 단위.
		
		for (int i = 0; i < 100000; i++) {
			arList.add(0, String.valueOf(i)); // valueof(int i) :  인수로 전달된 기본형 값을 참조형인 문자열로 변환하여 리턴.
		}
		
		long end = System.currentTimeMillis();
		System.out.println("ArrayList의 자료 추가 작업 시간: "+ (end- start)/1000. + "초");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			arList.get(i);
		}
		end=System.currentTimeMillis();
		System.out.println("ArrayList의 자료 읽기 작업 시간: "+ (end- start)/1000. + "초");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			lkList.add(0, String.valueOf(i));
		}
		end=System.currentTimeMillis();
		System.out.println("LinkedList의 자료 추가 작업 시간: "+ (end- start)/1000. + "초");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			lkList.get(i);
		}
		end=System.currentTimeMillis();
		System.out.println("LinkedList의 자료 읽기 작업 시간: "+ (end- start)/1000. + "초");
	}
}

import java.util.ArrayList;
import java.util.Iterator;

class Insert {
	public void insert() {
		ArrayList<Character> str = new ArrayList<Character>();
		
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			for(char j ='a'; j <= 'z'; j++) {
				str.add(0,j);
			}
		}
		long ed = System.currentTimeMillis();
		
		System.out.println(Thread.currentThread().getName() + " : " + (ed - st) / 1000.);
	}
}

class Insert1 extends Insert implements Runnable {
	public void run() {
		insert();
	}
}


public class JAVA1206_4 {
	public static void main(String[] args) {
		Thread insert = new Thread(new Insert1(), "insert1");
		// Thread(runnable 객체, 스레드명) : 스레드 클래스의 오버로딩 생성자.
		
		insert.start();
		Thread.currentThread().setName("Insert0");
		
ArrayList<Character> str = new ArrayList<Character>();
		
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			for(char j ='a'; j <= 'z'; j++) {
				Thread.yield();
				// yield() : 시스템 스케줄러에 결정된 스레드간 상대적 실행 우선순위 양보하되 그 시점 예측 불가.
				// sleep() 메서드와 같이 thread 클래스의 정적메서드. 항상 현재 스레드가 대상. 외부스레드 제어불가.
				// 단, sleep()메서드와 같은 예외 처리는 불필요.
			
				str.add(0,j);
			}
		}
		long ed = System.currentTimeMillis();
		
		System.out.println(Thread.currentThread().getName() + " : " + (ed - st) / 1000.);
	
		
	}

}

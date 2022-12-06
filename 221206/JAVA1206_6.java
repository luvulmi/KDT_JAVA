class Th01 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Th1 : " + i);
			try {Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("<<Th1완료>>");
		System.out.println();
	}
}

class Th02 extends Thread {
	public void run() {
		Th01 th1 = new Th01();
		
		th1.setDaemon(false); // 사용자 스레드 지정.
		th1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Th2 : " + i);
			try {Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Th2완료");
		System.out.println();
	}
}

public class JAVA1206_6 {
	public static void main(String[] args) {
		Th02 th2 = new Th02();
		
		th2.setDaemon(true); // th2는 데몬 스레드 지정했지만 메인 스레드와 th1은 사용자 스레드이므로
		th2.start();		 // th2가 실행중임에도 두 스레드가 종료되면 th2도 강제 종료.
		
		for (int i = 0; i < 10; i++) {
			System.out.println("메인스레드 : " + i);
			try {Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("<<메인스레드 완료>>");
		
	}

}

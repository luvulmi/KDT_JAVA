class Th1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Th1 : "+ i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("<<t1 완료>>");
		System.out.println();
	}
}

class Th2 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Th2 : "+ i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("<<t2 완료>>");
		System.out.println();
	}
}
public class JAVA1206_5 {
	public static void main(String[] args) {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		
		try {
			Thread.currentThread().join();
		} catch (Exception e) {
		}
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
		}
		
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("메인스레드 : "+ i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("<<메인스레드 완료>>");
		
	}

}

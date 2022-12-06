class SuperClass {
	public void special() { // 어떤 클래스의 아주 특별하고 잘 정의된 메서드로 가정.
		for (int i = 0; i < 25; i++) {
			System.out.println("run");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 다중상속을 지원하지않는 자바 특성상 어떤 임의 클래스의 잘 정의된 메서드를 스레드로 구현하고자 할 때,
// 임의 클래스 + 스레드 클래스 다중상속 받아야하는 문제 발생.
// 이런 경우 아래와 같이 Runnable 인터페이스 구현, run() 추상메서드 재정의하여 그 내부에서 상속받은 메서드 사용.


class MyThread extends SuperClass implements Runnable {
	public void run() {
		special();
	}
}

public class JAVA1206_2 {
	public static void main(String[] args) {
		Thread test = new Thread(new MyThread());

		test.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

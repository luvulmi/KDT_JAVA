class Event extends Thread {
	public void run() {
		for(;;) {
			System.out.println("이벤트 처리중...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("인터럽트 발생");
				return;
			}
		}
	}
}


public class JAVA1207_5 {
	public static void main(String[] args) {
		Event event = new Event();
		
		event.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		event.interrupt();
		// sleep, wait, join 등과 같이 스레드를 대기 시키고 있을 때,
		// 만약 더 이상 스레드의 대기가 필요없는 경우 이와 같이 interrupt()메서드를 통해
		// 외부에서 강제로 인터럽트 발생시킴으로써 스레드 대기 해제 가능.

	}

}

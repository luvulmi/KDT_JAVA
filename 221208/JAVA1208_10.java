import java.util.Timer;
import java.util.TimerTask;

class TimerTask1 extends TimerTask {
	@Override
	public void run() {
		System.out.println("1번 작업");
	}
}

class TimerTask2 extends TimerTask {
	@Override
	public void run() {
		System.out.println("2번 작업");
	}
}

class TimerClass{ // 메인 스레드
	public TimerClass() {
		Timer timer = new Timer();
		
		TimerTask1 task1 = new TimerTask1(); // 메인 스레드 종속 스레드이면서 데몬 스레드
		TimerTask2 task2 = new TimerTask2();
		
		timer.schedule(task1, 2000); // task 객체 1/1000초 지연 후 실행.
		timer.schedule(task2, 4000);
		
		System.out.println("작업 시작");
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
		}
		timer.cancel(); // timer 객체 사용이 끝난 다음에는 cancel 메서드 통해 메인 스레드 해제.
	}
}

public class JAVA1208_10 {
	public static void main(String[] args) {
		TimerClass timerclass = new TimerClass();
		
	}

}

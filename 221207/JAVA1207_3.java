// 공유 객체
class Data3 {
	String ar = "01234567890123456789";
	int idx = -1;
}

class InputOne2 extends Thread {
	Data3 data; // 개별 스레드가 공유 객체 접근하기 위해 스레드 생성자 인수로 공유 객체 전달.

	public InputOne2(Data3 data) {
		this.data = data;
	}

	public void run() {
		for (;;) {
			synchronized (data) {
				data.notify();
				if (data.idx >= data.ar.length() - 1) break;
				data.idx++;
				System.out.print(data.ar.charAt(data.idx) + " ");
				System.out.println(Thread.currentThread().getName());
				
				// 공유 인덱스가 공유 객체 소속 배열 인덱스 종료값이면 루프 종료 + 스레드 또한 종료.
				try {
					data.wait(); // 점유 대기.
				} catch (InterruptedException e) {
				}
				// 공유 객체에 저장할 스레드 데이터 임의 숫자 1로 가정.
			}
			
		}

	}
}


public class JAVA1207_3 {
	public static void main(String[] args) {
		Data3 data = new Data3(); // 공유 객체 생성.
		InputOne2 th1 = new InputOne2(data); // 공유 객체 접근 위해 스레드 생성자에 공유 객체 data 전달.
		InputOne2 th2 = new InputOne2(data);
		
		th1.start();
		th2.start();
		
		try {
			th1.join(); // 스레드 1,2 모든 실행 완료후 공유 객체 출력을 위해 join 설정.
			th2.join();
		} catch (InterruptedException e) {
		}
	}

}
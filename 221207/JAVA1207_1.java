// 공유 객체
class Data {
	int[] ar; // 공유 배열
	int idx; // 공유 인덱스

	public Data(int size) {
		ar = new int[size];
		idx = -1;
	}

	public void outputData() {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
}

class InputOne extends Thread {
	Data data; // 개별 스레드가 공유 객체 접근하기 위해 스레드 생성자 인수로 공유 객체 전달.

	public InputOne(Data data) {
		this.data = data;
	}

	public void run() {
		for (;;) {
			if (data.idx >= data.ar.length - 1) break;
			// 공유 인덱스가 공유 객체 소속 배열 인덱스 종료값이면 루프 종료 + 스레드 또한 종료.
			data.idx++;
			data.ar[data.idx] = 1;
			// 공유 객체에 저장할 스레드 데이터 임의 숫자 1로 가정.
			
		}

	}
}

class InputTwo extends Thread {
	Data data;

	public InputTwo(Data data) {
		this.data = data;
	}

	public void run() {
		for (;;) {
			if (data.idx >= data.ar.length - 1) break;
			data.idx++;
			data.ar[data.idx] = 2;
			// 공유 객체에 저장할 스레드 데이터 임의 숫자 2로 가정.
		}

	}
}

public class JAVA1207_1 {
	public static void main(String[] args) {
		Data data = new Data(20); // 공유 객체 생성.
		InputOne th1 = new InputOne(data); // 공유 객체 접근 위해 스레드 생성자에 공유 객체 data 전달.
		InputTwo th2 = new InputTwo(data);
		
		th1.start();
		th2.start();
		
		try {
			th1.join(); // 스레드 1,2 모든 실행 완료후 공유 객체 출력을 위해 join 설정.
			th2.join();
		} catch (InterruptedException e) {
		}
		data.outputData();
	}

}
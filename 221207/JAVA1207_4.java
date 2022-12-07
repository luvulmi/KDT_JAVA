class Data4 implements Runnable {
	int[] ar; // 공유 배열
	int idx; // 공유 인덱스

	public Data4(int size) {
		ar = new int[size];
		idx = -1;
	}

	public void outputData() {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

	public synchronized void run() {
		String str = Thread.currentThread().getName();
		
		for (;;) {
			this.notify();
			if (idx >= ar.length - 1)
				break;
			idx++;
			ar[idx] = Integer.parseInt(str.charAt(str.length() - 1) + "") + 1;
			// 문자열 -> 숫자로 변환 메서드. char + "" 함으로써 문자열로 변환해주기.

			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
	}
}

public class JAVA1207_4 {
	public static void main(String[] args) {
		Data4 data = new Data4(20);
		Thread th1 = new Thread(data);
		Thread th2 = new Thread(data);

		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
		}
		data.outputData();
	}

}

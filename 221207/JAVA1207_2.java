class Data1 implements Runnable {
	String ar = "01234567890123456789";
	int idx = -1;

	public synchronized void run() {
		for (;;) {
			this.notify();
			if (idx >= ar.length() - 1) {
				break;
			}

			idx++;
			System.out.print(ar.charAt(idx) + " ");
			System.out.println(Thread.currentThread().getName());

			try {
				this.wait(0);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

public class JAVA1207_2 {
	public static void main(String[] args) {
		Data1 data = new Data1();
		Thread th1 = new Thread(data);
		Thread th2 = new Thread(data);

		th1.start();
		th2.start();

	}

}

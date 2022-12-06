// 공유 객체
class Num {
	int sum = 0;
	int n = 0;
}

class Th001 extends Thread {
	Num num;
	
	public Th001(Num num) {
		this.num = num;
	}
	
	public void run() {
		for (int i = 1; i <= 50; i++) {
			// 동시 접근 문제 해결을 위한 동기화 블럭 지정.
			synchronized (num) {
				num.n++;
				num.sum += num.n;
				
				System.out.println(i + " : " + num.n);
				
				num.notify();
				if(i == 50) break; // 50일 때 브레이크.
				try {
					num.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

class Th002 extends Thread {
	Num num;
	
	public Th002(Num num) {
		this.num = num;
	}
	
	public void run() {
		for (int i = -1; i >= -50; i--) {
			synchronized (num) {				
				num.n++;
				num.sum += num.n;
				
				System.out.println(i + " : " + num.n);
				
				num.notify();
				if(i == -50) break;
				try {
					num.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
public class JAVA1206_7 {
	public static void main(String[] args) {
		Num num = new Num();
		Th001 th1 = new Th001(num);
		Th002 th2 = new Th002(num);
		
		th1.start();
		th2.start();
		
		try {
			// 누적합을 마지막에 실행되게 하기 위함.
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
		}
		System.out.println();
		System.out.println(num.sum);
	}

}

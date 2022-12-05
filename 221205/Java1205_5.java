//class Test extends Thread { // 사용자 스레드.
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("바보");
//			try {
//				Thread.sleep(400);
//			}catch (Exception e) {
//			}
//		}
//	}
//}
public class Java1205_5 {
	public static void main(String[] args) {
		
		// 익명 이너 클래스 생성. -> 일회성으로 실행할 것이므로 변수로 받을 필요 없음.
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("바보");
					try {
						Thread.sleep(400);
					}catch (Exception e) {
					}
				}
			}
		}.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("너는");
			try {
				Thread.sleep(400);
			}catch (Exception e) {
			}
		}
		
	}

}
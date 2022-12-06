public class JAVA1206_1 {
	public static void main(String[] args) {
		new Thread(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("바보");
					try {
						Thread.sleep(400);
					} catch (Exception e) {
					}
				}
			}).start();
		

		for (int i = 0; i < 10; i++) {
			System.out.println("너는");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
		}
	}

}

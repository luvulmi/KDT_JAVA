public class JAVA1208_7 {
	public static void main(String[] args) {
		
		String alphabet = new String();
		StringBuilder alphabet1 = new StringBuilder();
		StringBuffer alphabet2 = new StringBuffer();
		long st, ed;

		st = System.currentTimeMillis(); // 현재시간.
		for (int k = 0; k < 10000; k++) {
			for (char i = 'A'; i <= 'Z'; i++)
				alphabet += i;
		}
		ed = System.currentTimeMillis();
		System.out.println("경과시간 : " + (ed - st) / 1000.0 + "초");

		st = System.currentTimeMillis();
		for (int k = 0; k < 10000; k++) {
			for (char i = 'A'; i <= 'Z'; i++)
				alphabet1.append(i);
		}
		ed = System.currentTimeMillis();
		System.out.println("경과시간 : " + (ed - st) / 1000.0 + "초");

		st = System.currentTimeMillis();
		for (int k = 0; k < 10000; k++) {
			for (char i = 'A'; i <= 'Z'; i++)
				alphabet2.append(i);
		}
		ed = System.currentTimeMillis();
		System.out.println("경과시간 : " + (ed - st) / 1000.0 + "초");

	}
}

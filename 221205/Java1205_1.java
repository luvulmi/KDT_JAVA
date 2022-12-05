
public class Java1205_1 {
	public static void main(String[] args) throws InterruptedException {
		try {
			call();
			System.out.println("다음 문장");			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("메서드 호출");
	}

	static void call() throws Exception {
		throw new ArithmeticException();			
	}
}
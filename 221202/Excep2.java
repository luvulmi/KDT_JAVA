

public class Excep2 {
	public static void main(String[] args) {
		try {
			ClassCastException ex = new ClassCastException();
			
			throw new ClassCastException();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		
		System.out.println("실행 완료");

	}

}

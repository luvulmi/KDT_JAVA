public class J1202_3 {
	public static void checkAdult(int[] age) {
		for (int i : age) {
			if(i > 20) {
				System.out.println(i);
			}
		}
		System.out.println();
	}
	public static void checkMinor(int[] age) {
		for (int i : age) {
			if(i < 20) { // 조건 비교란에 boolean값이 반환받아야함. 
				System.out.println(i);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] age = new int[] {43, 19, 27, 15, 36};
		checkAdult(age);
		checkMinor(age);
	}

}

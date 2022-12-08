
public class JAVA1208_1 {
	public static void main(String[] args) {
		int[] ar1 = {1,2,3,4,5};
		int[] ar2 = new int[5];
		
		System.arraycopy(ar1, 0, ar2, 0, 5);
		
		for (int i : ar2) {
			System.out.println(i);
		}
		
	}

}

public class Excep {
	public static void main(String[] args) {
		int ar[] = { 1, 2, 3, 4, 5 };
		int ix = 12;

		try {
			System.out.println(ix / 2);
			System.out.println("요기두 처리");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("연산끝");
		System.out.println();

		try {
			System.out.println(ix / 0);
			System.out.println("요기요??");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("연산끝");
		System.out.println();

		try {
			System.out.println(ix / 0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("연산끝");
		System.out.println();

		try {
			System.out.println(ar[ix]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());

			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("연산끝");
		System.out.println();

		try {
			System.out.println(ar[ix]);
			System.out.println(ix / 0);
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println("연산끝");
		System.out.println();

	}

}

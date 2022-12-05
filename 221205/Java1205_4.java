import java.util.Scanner;

public class Java1205_4 {
	static final int correctpw = 1234; // 저장되어 있는 비밀번호 가정.
	static int pw = 0; // 입력 비밀번호.
	static int flag = 0; // inputpw 메서드에 대한 최초 호출 명시 스위치.

	// 호출부
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 비밀번호 입력 위한 메서드. 3회 입력 후에는 스캐너 객체 close.
		inputpw(sc);

		inputpw(sc);

	}

	// 예외 발생부
	static void inputpw(Scanner sc) {
		try {
			for (int i = 0; i < 3; i++) {
				if (flag == 0) {
					System.out.print("패스워드 숫자 4자리 입력 : ");
				}

				try {
					pw = sc.nextInt();

					if (pw == correctpw) {
						System.out.println("패스워드 일치 로그인 성공");
						return;
						// 리턴이 됨에도 finally는 실행.
					}
				} catch (Exception e) {
					try {
						sc.nextLine(); // 오류나는 원인. 입력 객체를 예외 처리 구문에서 받고있음!						
					} catch (Exception e2) {
						if (pw != correctpw) {
							System.out.println("로그인 못해요. 은행가세요.");
						}
						return;
					}
					System.out.println(i + 1 + "회 입력오류");
					System.out.println("숫자만 입력 가능");
					continue;
				}
				System.out.println(i + 1 + "회 입력오류");
			}
		}
		// finally 사용을 위해 외부에 try ~ finally 블럭 설정.
		// 내부에 설정 시 루프 1회전시에도 스캐너 객체가 닫혀버려 2회전부터는 사용할 수 없는 오류때문.
		finally {
			flag = 1;
			sc.close(); // 스위치 설정과 스캐너 객체 해제는 비밀번호 일치 여부 떠나 설정되어야하는 공통 코드.
		}
	}

}

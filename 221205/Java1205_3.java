import java.util.Scanner;

public class Java1205_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0; // 예외가 발생하는 경우 catch블럭에서 초기화 시키지 않으면 null 처리할 소지가 있으므로
					 // 초기화 강제.
		
		try {
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("예외 발생");
		} finally { // 예외 발생 여부와 상관없이 처리.
			System.out.println("스캐너 자원 해제"); 
			sc.close();
		}
		
		System.out.println(num);
		
	}

}

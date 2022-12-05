import java.util.Scanner;

class UserDefException extends Exception {
	UserDefException(String exContent) {
		super(exContent);
		// 예외 객체 생성 시 생성자를 통해 문자열 전달 가능. -> getMessage() 이용 상세 예외내용 명시 가능.
		// 단, 사용자 정의 예외 경우 생성자는 상속되지 않으므로 생성자를 위와 같이 정의 후 super키워드로 문자열 전달해야함.
	}
}

abstract class Sum { // 객체 생성이 목적이 아닌 내부 메서드만 활용하기 위해 추상클래스로 선언.
										 // 내부 메서드 또한 정적으로 선언.
	static void sum(int st, int ed) throws UserDefException {
		int tot = 0;
		
		if(st > ed) {
			throw new UserDefException("입력 오류!! 작은 수 먼저 입력되야해요~ \n");
		}
		
		for (int i = st; i <= ed; i++) {
			tot += i;
		}
		
		System.out.printf("%d에서 %d까지의 합은 %d입니다.", st, ed, tot);
	}
}

public class Java1205_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int st, ed;
		
		for(;;) {
			try {
				System.out.print("작은 수 입력 : ");
				st = input.nextInt();
				System.out.print("큰 수 입력 : ");
				ed = input.nextInt();
				
				Sum.sum(st, ed); // Sum 추상 클래스의 sum 메서드 호출.
			} catch (UserDefException e) {
				System.out.print(e.getMessage());
				System.out.println("재입력 바래요~\n");
				continue;
			} catch (Exception e) {
				System.out.println("숫자만 입력 가능~\n");
				
				input.nextLine(); // 문자열 입력 메서드. nextLine 메서드 이전에 입력 메서드가 존재하고 그 메서드가 개행 문자를 포함하지 않는다면 버퍼에 남아있던 개행문자가 메서드로 전이되어 입력이 무시되는 효과 발생. 
										      // 잘못 입력된 값이 남아있으므로 초기화 해주는 코드.
				continue;
			}
			
			input.close();
			break;
		}
	}

}
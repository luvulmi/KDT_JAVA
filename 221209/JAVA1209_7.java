import java.io.FileOutputStream;
import java.io.IOException;

public class JAVA1209_7 {
	public static void main(String[] args) {
		byte[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		FileOutputStream outobj = null; // 파일은 실제 메모리 내부에 존재하는 것이 아니라 외부에 존재하여 이에 따른 입출력 스트림 생성 및 제어 시
										// 예외 발생 소지가 높아 예외 처리 필수. 
										// 그러나 입출력 스트림 변수는 예외블럭 바깥에 선언. NULL로 초기화 필수. 
										// 예외 블럭 내부에 선언을 하면 예외 발생 시 변수가 무효화 되므로 바깥에 선언.
										// null로 초기화를 하지 않으면 예외 발생 시 객체 생성 자체가 무효화되어 쓰레기 값에 대한 close 메서드 호출
										// 컴파일 자체가 불가.
		
		try {
			outobj = new FileOutputStream("Binaryout.bin");
			
			outobj.write(data);
			System.out.println("파일에 데이터 출력 완료!!");
		} catch (IOException e) {
			System.out.println("파일에 데이터 출력 실패!!");
		} finally {
			try {
				outobj.close(); // 파일에 입출력 스트림 미해제 시 파일에 대한 스트림이 개방된 상태라 파일이 손상될 수 있으며
								// 메모리 상주로 자원 소모될 수 있으니 반드시 스트림 닫기 필수.
			} catch (IOException e2) {
				System.out.println("파일 닫기 실패!!");
			}
		}
	}

}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JAVA1209_8 {
	public static void main(String[] args) {

		FileInputStream inObj = null;

		try {
			inObj = new FileInputStream("Binaryout.bin"); // FileInputStream(String name)
															// 입력받을 파일의 경로와 파일 이름을 문자열 형태로 전달.
															// 전달된 경로 파일로부터 입력 스트림 스트림 개방.
			int data;

			for (;;) {
				data = inObj.read(); // int read() : 1byte씩 읽은 데이터를 리턴하되 파일의 끝이면 -1 반환.

				if (data == -1) break;
				System.out.println(data);
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 실패!!");
		} finally {
			try {
				inObj.close();
			} catch (IOException e2) {
				System.out.println("파일 닫기 실패!!");
			}
		}
	}

}

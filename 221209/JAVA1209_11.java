import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JAVA1209_11 {
	public static void main(String[] args) {

		BufferedInputStream bufInput = null;
		BufferedOutputStream bufOutput = null;
		int data;
		
		try {
			bufInput = new BufferedInputStream(new FileInputStream("Binaryout.bin"));
			bufOutput = new BufferedOutputStream(new FileOutputStream("Bufout.bin"));
			// 버퍼 입출력 스트림에 파일 입출력 스트림 객체만 전달하면 이후 데이터 읽고쓰는 제어는 입출력 스트림 메서드와 동일.
			
			for(;;) {
				data = bufInput.read();
				
				if(data == -1) break;
				
				bufOutput.write(data);
			}
			System.out.println("버퍼 이용한 파일 데이터 입출력 완료!!");
		} catch (IOException e) {
			System.out.println("버퍼 이용한 파일 데이터 입출력 실패!!");
		}finally {
			try {
				bufInput.close();
				bufOutput.close();
				// 파일 입출력 스트림 별도로 닫을 필요 없이 버퍼 입출력 스트림만 닫아도 파일 스트림은 자동 해제.
				
			} catch (IOException e2) {
				System.out.println("버퍼를 이용한 파일 닫기 실패!!");
			}
		}
	}
}

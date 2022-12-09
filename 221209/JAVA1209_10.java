import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JAVA1209_10 {
	public static void main(String[] args) {
		FileInputStream input = null;
		FileOutputStream out = null;
		BufferedInputStream bufInput = null;
		BufferedOutputStream bufOutput = null;
		long std;
		int data;
		
		std = System.currentTimeMillis();
		try {
			input = new FileInputStream("자바교본정리3.pdf");
			out = new FileOutputStream("copy.pdf");
			
			for(;;) {
				data = input.read();
				
				if(data == -1) break;
				
				out.write(data);
			}
		} catch (IOException e) {
			System.out.println("파일 복사 실패!!");
		}finally {
			try {
				input.close();
				out.close();
			} catch (IOException e2) {
				System.out.println("파일 닫기 실패!!");
			}
		}
		System.out.printf("copytest1 복사 시간 %.3f초\n", (System.currentTimeMillis()-std)/1000.);
		
		std= System.currentTimeMillis();
		try {
			bufInput = new BufferedInputStream(new FileInputStream("자바교본정리3.pdf"));
			bufOutput = new BufferedOutputStream(new FileOutputStream("copy.pdf"));
			
			for(;;) {
				data = bufInput.read();
				
				if(data == -1) break;
				
				bufOutput.write(data);
			}
		} catch (IOException e) {
			System.out.println("파일 복사 실패!!");
		}finally {
			try {
				bufInput.close();
				bufOutput.close();
			} catch (IOException e2) {
				System.out.println("파일 닫기 실패!!");
			}
		}
		System.out.printf("copytest2 복사 시간 %.3f초\n", (System.currentTimeMillis()-std)/1000.);
		
	}
}

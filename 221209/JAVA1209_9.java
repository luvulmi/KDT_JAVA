import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JAVA1209_9 {
	public static void main(String[] args) {

		FileInputStream inObj = null;
		FileOutputStream outObj = null;

		try {
			inObj = new FileInputStream("Binaryout.bin"); 
			outObj = new FileOutputStream("Binarycopy.bin");
			int data;

			for (;;) {
				data = inObj.read();

				if (data == -1) break;
				outObj.write(data);
			}
			System.out.println("파일 복사 성공!!");
		} catch (IOException e) {
			System.out.println("파일 복사 실패!!");
		} finally {
			try {
				inObj.close();
				outObj.close();
			} catch (IOException e2) {
				System.out.println("파일 닫기 실패!!");
			}
		}
	}

}

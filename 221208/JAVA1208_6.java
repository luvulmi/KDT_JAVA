
public class JAVA1208_6 {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Teacher");
		
		System.out.println(str.append(" is my love.")); // 문자열 추가.
		
		System.out.println(str.delete(5, 7)); // 5부터 7 바로전까지 문자열 삭제.
		
		System.out.println(str.insert(5, "ing")); // 5부터 문자열 삽입.
		
		System.out.println(str.deleteCharAt(str.length() -1)); // 해당 인덱스 위치 문자값 삭제.
		
		System.out.println(str.replace(0, 8, "Mother")); // 0부터 8 바로전까지 문자열 대체.
		
		System.out.println(str+"\n");
		
		StringBuffer str1 = new StringBuffer("Student");
		
		System.out.println(str1.append(" is my love."));
		System.out.println(str1.delete(0,7));
		System.out.println(str1.insert(0,"Tori"));
		System.out.println(str1.deleteCharAt(str1.length() -1));
		System.out.println(str1.replace(0, 4, "My life"));
		System.out.println(str1+"\n");
		
		String str2 = "바다의 보배";
		
		str = new StringBuilder(str2);
		System.out.println(str);
		
//		str2 = str1             // string형으로 직접 대입 불가. 
		str2 = str1.toString(); // 메서드 통해 대입 가능.
		System.out.println(str2);
		
//		str1 = str2               
		str1 = new StringBuffer(str); // 빌드와 버퍼간 객체 전달도 직접은 불가.
		str = new StringBuilder(str1); // 생성자 통해서 가능.
		
	}
	
}

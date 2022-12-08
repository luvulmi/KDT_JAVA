
public class JAVA1208_3 {
	public static void main(String[] args) {
		String str = "KYR jjang";
		String str1 = "KYR jjang";
		String str2 = "";
		String str3 = " ";
		String str4 = "kyr jjang";
		String str5 = "School";
		String str6 = "World";
		String str7 = "school";		
		
		System.out.println(str.length()); // 공백포함 문자열 길이 조사.
		
		System.out.println(str.charAt(0)); // 인수에 해당하는 인덱스의 문자값 리턴.
		System.out.printf("%b %b %b\n\n", str.isEmpty(), str2.isEmpty(), str3.isEmpty());
		// 대상 문자열이 빈문자열 인지 조사. 공백이 아님에 유의
		
		System.out.println(str.equals(str4));
		System.out.println(str.equalsIgnoreCase(str4));
		// 대소문자 무시하여 문자열 비교.
		
		System.out.println();
		System.out.println(str.compareTo(str1)); // 인수객체의 사전순서에 대한 대/소 비교.
		System.out.println(str5.compareTo(str6)); 
		System.out.println(str5.compareTo(str7)); 
		// 같으면 0, 다르면 (호출객체 - 인수객체) 연산을 하므로 호출객체가 인수객체보다 앞쪽이면 음수, 뒤쪽이면 양수 리턴.
		
		System.out.println();
		System.out.println(str.compareToIgnoreCase(str4)); // 대소문자 무시하여 비교.
				
	}
}

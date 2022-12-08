
public class JAVA1208_5 {
	public static void main(String[] args) {
		String str = "    Made In Korea ";
		String str1= "Finghtin!!";
		
		System.out.println(str);
		System.out.println(str.toLowerCase());	// String toLowerCas() : 모든 영문자를 '소문자'로 변경한 문자열 리턴.
		System.out.println(str);	
		String str2=str.toUpperCase();			// String toLowerCase() : 모둔 영문자를 '대문자'로 변경한 문자열 리턴.
		System.out.println(str2+"\n");
		
		
		System.out.println(str.trim());			// String trim() : 해당 문자열의 중간 공백을 제외한 앞, 뒤 공백을 제거한 문자열 리턴
		System.out.println(str+str1);
		System.out.println(str.concat(str1).concat("Peace!!"));		//  String concat(String str) : 문자열과 문자열을 연결한 문자열 리턴.
		System.out.println(str+"\n\n");
		
		
		String str3="푸들은 강아지다. 말티지는 강아지다.";
		
		System.out.println(str3.replace('다','니'));		// replace( char oldChar, char newChar ) : 문자열 내의 모든 oldChar를 newChar 로
														// 대체한 문자열 리턴.
		
		System.out.println(str3.replace("강아지","개"));  // replace( CharSequence target, CharSequence replacement ) : 문자열 내의
														// 모든 target을 replacement로 대체한 문자열 리턴.
		
		System.out.println(str3.substring(4));			// substring( int beginIndex [, endIdex ] ) : 종료 인덱스가 생성된 경우 시작
		System.out.println(str3.substring(4, 14));		// 인덱스부터 문자열 끝까지 추출하고 끝 인덱스가 지정된 경우 시작 인덱스 부터 끝 인덱스 전까지만 추출.
	}													// 끝 인덱서는 추출 대상에 포함 되지 않음에 유의.

}

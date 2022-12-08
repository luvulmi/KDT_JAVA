import java.util.StringTokenizer;

public class JAVA1208_11 {
	public static void main(String[] args) {
		String str = "월 화 수 목 금 토 일";
		String str1 = "월요일,화요일,수요일,목요일,금요일,토요일,일요일";
		
		StringTokenizer token = new StringTokenizer(str);
		StringTokenizer token1 = new StringTokenizer(str1,",");
		// str1 문자열에서 , 를 구분자로 인식. 생성자 인수를 생략하면 공백,탭,개행등을 구분자로 자동 인식.
		
		while(token.hasMoreTokens()) { // 토큰(부분 문자열)이 더 있는지 조사. 있으면 1, 없으면 0
			System.out.println(token.nextToken()); // 다음 토큰이 되는 부분 문자열 추출.
		}
		
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		
	}
}

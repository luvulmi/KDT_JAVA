import java.util.StringTokenizer;

public class JAVA1208_12 {
	public static void main(String[] args) {
		String str = "월 화 수 목 금 토 일";
		String str1 = "월요일,화요일,수요일,목요일,금요일,토요일,일요일";
		
		StringTokenizer st1 = new StringTokenizer(str);
		StringTokenizer st2 = new StringTokenizer(str1, ",");
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		System.out.println();
		
		for(String s : str.split(" ")) {
			System.out.println(s);
		}
		System.out.println();
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		for(String s : str1.split(",")) { // split 메서드는 널값도 토큰으로 인정.
			System.out.println(s);
		}
		System.out.println();		
		
	}
}

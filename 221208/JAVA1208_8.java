import java.util.Calendar;

public class JAVA1208_8 {
	public static void main(String[] args) {
		Calendar t = Calendar.getInstance(); // 싱글톤 패턴.
		
		System.out.print(t.get(Calendar.YEAR)+"년 "); // int get(int field) : 객체에 소속된
													  // 일반 메서드로써 정적 상수 필드 인수로 전달.
		
		System.out.print(t.get(Calendar.MONTH)+1+"월 "); // 월의 경우 0부터 리턴됨에 유의.
		System.out.print(t.get(Calendar.DAY_OF_MONTH)+"일 ");
		System.out.print(t.get(Calendar.AM_PM)==0? "AM " : "PM "); // AM(0), PM(1)
		System.out.print(t.get(Calendar.HOUR)+"시 ");
		System.out.print(t.get(Calendar.MINUTE)+"분 ");
		System.out.print(t.get(Calendar.SECOND)+"초 ");
		
	}

}

public class JAVA1207_8 {
	public static void main(String[] args) {
		int i=1, j=2, k=4;
		String str, str2, str3;
		
//		str = (String)i;
//		str = i.toString();
		
		Integer wrapint = new Integer(i); // 래퍼 클래스 생성자 통한 박싱.
		
		Integer wrapint2 = j; // 오토박싱. valueOf 메서드와 동일한 정적 객체 리턴.
		
		Integer wrapint3 = Integer.valueOf(k);
		
		str = wrapint.toString();
		str2 = wrapint2.toString();
		str3 = wrapint3.toString();
		
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3+"\n");
		
		Integer wrapint_1 = new Integer(i);
		System.out.println(System.identityHashCode(wrapint)); // 인수에 지정된 객체에 대한 정수형 해시값 리턴.
		System.out.println(System.identityHashCode(wrapint_1)+"\n");
		
		Integer wrapint_2 = j;
		System.out.println(System.identityHashCode(wrapint2));
		System.out.println(System.identityHashCode(wrapint_2)+"\n");
		
		Integer wrapint_3 = Integer.valueOf(k);
		System.out.println(System.identityHashCode(wrapint3));
		System.out.println(System.identityHashCode(wrapint_3)+"\n");
		
		

	}

}

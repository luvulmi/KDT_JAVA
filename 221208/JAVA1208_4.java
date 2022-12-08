public class JAVA1208_4 {
	public static void main(String[] args) {
		String str = "String Search Method of String Class";
		
		System.out.println(str.indexOf('S'));
		System.out.println(str.indexOf('S', 5));
		System.out.println();
		
		System.out.println(str.indexOf("ing"));
		System.out.println(str.indexOf("ing",10));
		System.out.println();
		
		System.out.println(str.lastIndexOf('a'));
		System.out.println(str.lastIndexOf('a',5));
		System.out.println();
		
		System.out.println(str.lastIndexOf("ing"));
		System.out.println(str.lastIndexOf("ing",20));
		System.out.println();
		
		System.out.println(str.startsWith("Str"));
		System.out.println(str.startsWith("Sea",7));
		
		System.out.println(str.endsWith("ass"));
		
	}
}

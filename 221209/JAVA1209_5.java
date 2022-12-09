import java.util.HashMap;
import java.util.Map;


public class JAVA1209_5 {
	public static void main(String[] args) {

		 HashMap<String, String> phoneBook = new HashMap<String, String>(); // <키 값, value값>
	      
	      phoneBook.put("박성연", "010-1234-5678");      // put(key, value) : 키와 값을 저장.
	      phoneBook.put("홍길동", "010-1111-5555");
	      phoneBook.put("김유신", "010-2222-6666");
	      phoneBook.put("이덕화", "010-3333-7777");
	      phoneBook.put("이순신", "010-4444-8888");
	      
	      // 해쉬맵 객체의 entrySet()메서드를 호출하면 키와 값들이 저장되어있는 Map인터페이스 소속의 정적객체 Entry의 참조가
	      // 반환되며 getKey(), getValue() 메서드를 통해 각각 키와 값을 참조 가능.
	      for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
	         System.out.printf("이름 : %s, 전화번호 :%s\n", entry.getKey(), entry.getValue());
	      }
	      System.out.println();
	      
	      
	      phoneBook.put("박성연", "010-1234-5678");   // 해쉬맵은 키에 의해 값의 매핑이 이루어지고  키의 중복이 허용되지 않아
	      phoneBook.put("이순신", "010-9999-1004");   // 중복되는 키에 대해서는 값의 갱신만 이루어짐.
	      for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
	         System.out.printf("이름 : %s, 전화번호 :%s\n", entry.getKey(), entry.getValue());
	      }
	      System.out.println();
	      
	      
	      System.out.println(phoneBook.get("박성연"));   // get(key) : 키 검색을 통해 값 반환. 키가 존재하지 않는
	      System.out.println(phoneBook.get("강감찬"));   //             경우 null 반환.
	      System.out.println();
	         
	      
	      phoneBook.remove("이덕화");   // remove(key) : 지정된 키와 값 삭제.
	      for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
	         System.out.printf("이름 : %s, 전화번호 :%s\n", entry.getKey(), entry.getValue());
	      }
	      System.out.println();
	      
	      
	      // containsKey, containsValue : 지정된 키와 값이 존재하는지 true, false 반환.
	      System.out.println(phoneBook.containsValue("010-1234-5678"));
	      System.out.println(phoneBook.containsKey("박성연"));  
	      System.out.println();
	      
	      
	      for (String k : phoneBook.keySet()) {   // keySet : 해쉬맵에 저장되어 있는 모든 키들에 대한 참조를 반환.
	         System.out.println(k);
	      }
	      for (String v : phoneBook.values()) {   // values : 해쉬맵에 저장되어 있는 모든 값들에 대한 참조를 반환.
	         System.out.println(v);
	      }
	      System.out.println();
	      
	      
	      System.out.println(phoneBook.size());
	      phoneBook.clear();                  // clear : 해쉬맵 모든 요소 삭제.
	      System.out.println(phoneBook.size());

	}

}

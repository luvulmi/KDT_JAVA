import java.lang.reflect.*; // Field, Method 클래스를 사용하기 위한 패키지.

class Car7 {
	String name;
	public String color;
	private boolean gasoline;
	
	public void run() {}
	void srop() {}
}

class Truck extends Car7 {
	public int ton;
	private String cargo;
	
	void convey() {}
	public void load() {}
	
}

public class JAVA1207_7 {
	public static void main(String[] args) {
		Car7 pride = new Car7();
		Class<?> cls = pride.getClass();
		// pride 객체의 클래스 정보를 포함하는 Class형 객체를 리턴받아 cls로 그 객체를 참조.
		
		System.out.println(cls);
		
		System.out.println("클래스 이름="+cls.getName());
		System.out.println("슈퍼클래스 이름=" + cls.getSuperclass().getName()+"\n");
		
		Class<?> cls2 = Car7.class;
		System.out.println("클래스 이름="+cls2.getName());
		System.out.println("슈퍼클래스 이름=" + cls2.getSuperclass().getName()+"\n");
		
		Truck poter = new Truck();
		Class<?> cls3 = poter.getClass();
		
		Field[] fields = cls3.getDeclaredFields(); // 필드 목록을 공개 여부 상관없이 field클래스 배열형태로 리턴.
		System.out.print("\n필드 : ");
		for(Field field : fields) {
			System.out.print(field.getName()+ " ");
		}
		
		Field[] fields2 = cls3.getFields(); // 상속받은 필드도 포함하여 목록도 리턴 public이 붙은 공개필드만 포함.
		System.out.print("\n필드 : ");
		for(Field field : fields2) {
			System.out.print(field.getName()+ " ");
		}
		
		Method[] methods = cls3.getDeclaredMethods(); // 공개 여부 상관 없이 method클래스 배열형태로 리턴.
		System.out.print("\n메서드 : ");
		for(Method method  : methods) {
			System.out.print(method.getName()+ " ");
		}
		
		Method[] methods2 = cls3.getMethods(); // 상속받은 메서드도 포함하여 목록도 리턴 public이 붙은 공개필드만 포함.
		System.out.print("\n메서드 : ");
		for(Method method  : methods2) {
			System.out.print(method.getName()+ " ");
		}
	}

}

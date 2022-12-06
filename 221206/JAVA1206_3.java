class Thread1 extends Thread {
	public Thread1() {}
	public Thread1(String name) {
		super(name);
	}
}

class Thread2 extends Thread {
	public Thread2() {}
	public Thread2(String name) {
		super(name);
	}
}

public class JAVA1206_3 {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		System.out.println(thread1.getName()); 
		System.out.println(thread2.getName()); 
		// getName() : 스레드 객체의 이름조사. 별도 지정없는 경우 생성 순서대로
		// Thread-n 형태로 지정.
		
		System.out.println(Thread.currentThread().getName());
		System.out.println();
		// currentThread() : thread 클래스의 정적 메서드로 현재 스레드 객체 리턴.
		// 메인 스레드 경우 별도 객체 생성을 안하므로 해당 메서드 통해 스레드 객체 관련 메서드 적용.
	
		
		thread1.setName("스레드1");
		thread2.setName("스레드2");
		Thread.currentThread().setName("메인 스레드");
		// setName() : 스레드 객체 이름 지정.
		
		System.out.println(thread1.getName()); 
		System.out.println(thread2.getName()); 
		System.out.println(Thread.currentThread().getName());
		System.out.println();
		
		
	}

}

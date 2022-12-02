interface Exercise{
   void walk();
   void run();
   default void jump() {
      System.out.println("점프");
   }
   
   static void training(Exercise ar) {      // 디폴트 메서드와 마찬가지로 static 지정자를 붙임으로써 본체를 정의해야 하며, 클래서와
      ar.run();                     // 동급인 인터페이스에 소속되고 공유 기능을 정의하는 등의 일반 정적 메서드와 개념적으로 동일.
      ar.walk();                      // 첨부하여 일반적 클래스간 상속 관계에서 비정적 멤버 뿐만이 아니라 정적 멤버 또한 상속 가능.
      ar.jump();                      // 단, 디폴트 메서드는 서브 클래스에서 재정의가 가능하나 정적 메서드는 인터페이스 내부 정보에
                                 // 대한 공유기능을 목적으로 정의한 것이므로 서브에서 재정의 불가.
                                 // 또한 공통의 상속 계층에 공유 기능을 제공하는 정적 메서드는 public 으로 정의하는 것이
                                 // 일반적이나, 인터페이스 내 메서드에 대한 본체 생성이 가능해짐으로써 내부적인 복잡한 처리나
                                 // 반복이 가능해지고 이러한 코드는 외부에 공개할 필요가 없어 자바 9 부터는 private 지정자를
                                 // 통해 외부에 비공개 처리.
   }
}
class Baseball implements Exercise{
   @Override
   public void walk() {
      System.out.println("걷기");
   }

   @Override
   public void run() {
      System.out.println("뛰기");
   }
   
   public void hit() {
      System.out.println("치다");      
   }
   
}

class Football implements Exercise{
   @Override
   public void walk() {
      System.out.println("걷기");
   }
   
   @Override
   public void run() {
      System.out.println("뛰기");
   }
   
   public void kick() {
      System.out.println("차다");
   }
   
   public void jump() {
      System.out.println("공중 드리블");
   }
}


public class Interface1202_2 {
	public static void main(String[] args) {
		Exercise baseball=new Baseball();
	      Exercise football = new Football();
	      
	      Exercise.training(baseball);
	      System.out.println();
	      Exercise.training(football);
	}

}

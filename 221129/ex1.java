enum TankTier {
   TIER1("1단계", 30), TIER2("2단계", 50), TIER3("3단계", 70), TIER4("4단계", 100);
// 열거상수에 대한 정적 객체에 해당.

// final > 값을 변경 불가하게 설정. 관례상 모두 대문자로 명칭.
// private > 클래스 외부로부터의 접근 보호.
   private final String STEP;
   final int DURABILITY;

   TankTier(String n, int dura) { // 개별 열거상수의 내부 필드 초기화를 위한 생성자.
      STEP = n; // this가 필요 없음.
      DURABILITY = dura;
   }

// 	하단부에서 내부적으로 호출하고 있으므로 getter는 필요치 않음.
//   public String getchapter() { // 개별 열거상수 내부필드 정보 얻기위한 메서드 선언.
//      return STEP;
//   }
//
//   public int getst() {
//      return DURABILITY;
//   }

   public static void TankInfo() {
      TankTier[] tanks = TankTier.values();
      System.out.print("전체 티어 및 내구도 : ");
      for (TankTier i : tanks) {
         System.out.printf("%s(%d) ", i, i.DURABILITY);
      }
   }

   public void myTank() {
      System.out.printf("\n\n현재 탱크 티어 : %s", STEP);
      System.out.printf("\n내구도 : %d", DURABILITY);
   }
}

public class ex1 {
   public static void main(String[] args) {
      TankTier.TankInfo();
      TankTier.TIER3.myTank();
   }
}
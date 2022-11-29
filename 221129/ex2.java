enum TankTier2 {
   TIER1("1단계", 30, 1), 
   TIER2("2단계", 50, 2), 
   TIER3("3단계", 70, 3, true, false),
   TIER4("4단계", 100, 3, true, true);

   private final String TIER;
   private final int SHOTLEVEL;
   private final int DURA;
   private boolean misile;
   private boolean nuclearMisile;

   TankTier2(String tier, int durability, int shotLevel){
      TIER = tier;
      DURA = durability;
      SHOTLEVEL = shotLevel;
   }
   
   TankTier2(String tier, int durability, int shotLevel, boolean misile, boolean nuclearMisile) {
      this(tier, durability, shotLevel);
      this.misile = misile;
      this.nuclearMisile = nuclearMisile;
   }

   public String getTIER() {
      return TIER;
   }

   public int getSHOTLEVEL() {
      return SHOTLEVEL;
   }

   public int getDURA() {
      return DURA;
   }

   public boolean isMISILE() {
      return misile;
   }

   public boolean isNUCLEARMISILE() {
      return nuclearMisile;
   }

}

class Tank {
   private final String NAME;
   private final TankTier2 TANKTIER;
   private static int counter = 0;
   
   Tank(String name, TankTier2 tier) {
      NAME = name;
      TANKTIER = tier;
      counter++;
   }

   public void Specview() {
      System.out.printf("탱크명 : %s\n", NAME);
      System.out.printf("티어 : %s\n", TANKTIER.getTIER());
      System.out.printf("내구도 : %d\n", TANKTIER.getDURA());
      System.out.printf("%d단계 포 장착\n", TANKTIER.getSHOTLEVEL());
      System.out.print("미사일 " + (TANKTIER.isMISILE() ? "" : "미") + "장착" + "\n");
      System.out.print("핵미사일 " + (TANKTIER.isNUCLEARMISILE() ? "" : "미") + "장착" + "\n");
      System.out.println("\n\n");
   }
   
   public void printTankName() {
      System.out.printf("<%s>\n",NAME);
   }
   
   private void shotAttack() {
      System.out.print("대포발사 :");
      
      for (int i = 0; i < TANKTIER.getSHOTLEVEL(); i++) {
         System.out.print("펑");
      }
      System.out.println();
   }
   
   private void misileAttack() {
      if(TANKTIER.isMISILE()) {
         System.out.println("미사일 발사: 초전박살");
      }
   }
   
   private void nuclareMisileAttack() {
      if(TANKTIER.isNUCLEARMISILE()) {
         System.out.println("핵미사일 발사: 김정은 사망");
      }
   }
   
   public void allAttack () {
      printTankName();
      shotAttack();
      misileAttack();
      nuclareMisileAttack();
      System.out.println("\n");
   }
   
    public static void productCount() {
        System.out.printf("생산된 탱크 댓수 : %d \n\n\n", counter);
    }
}

public class ex2 {
   public static void main(String[] args) {
      Tank k1 = new Tank("k1전차", TankTier2.TIER1);
      Tank k1a1 = new Tank("k1A1전차", TankTier2.TIER2);
      Tank x1 = new Tank("X1흑표전차", TankTier2.TIER3);
      Tank x2 = new Tank("X2흑표전차", TankTier2.TIER4);

      Tank.productCount();
      
      k1.Specview();
      k1a1.Specview();
      x1.Specview();
      x2.Specview();

      k1.allAttack();
      k1a1.allAttack();
      x1.allAttack();
      x2.allAttack();
   }

}

class Storage {
   private int[] storage; // 저장 할 배열.
   private int top = -1;  // 처음.
   private int end; 	  // 끝.
   
   // 배열 사이즈 지정 메서드.
   public Storage(int size) {
      storage = new int[size];
      end = size - 1; // 배열 길이 - 1 
   }
   
   // 배열 출력 메서드.
   public void printTarget(int[] target) {
      for (int t : target) {
         System.out.printf("%d ", t);
      }
      System.out.println();
   }
   
   // 남은 공간 출력 메서드.
   public void printRemainSpace() {
      System.out.printf("남은 공간은 %d개 입니다.\n", end - top);
      printTarget(storage);
      System.out.println();
   }
   
   // 저장 메서드.
   public void store(int...storeTarget) {
      System.out.print("저장 대상 : ");
      // 저장 대상 배열 프린트.
      printTarget(storeTarget);
      
      // 저장 배열 길이 > 끝 인덱스 - 첫 인덱스.
      if(storeTarget.length > end - top) {
         System.out.println("저장 불가 : 입력 인수가 저장공간 보다 크거나 공간이 부족합니다.");
      } else {
         for(int t:storeTarget) {
            storage[++top] = t; // 저장배열 인덱스 첫값부터 저장 대상으로 채워가기. 
         }
         
         if( top == end ) { // 인덱스가 가득 찬 경우.
            System.out.println("저장공간 가득참 - 입력금지");
         }
      }
      
      printRemainSpace();
   }
   
   // 삭제 메서드.
   public void drop(int... dropTarget) {
      int lastTop = top;
      
      System.out.print("삭제 대상 : ");
      // 삭제 대상 배열 프린트.
      printTarget(dropTarget);
      
      for(int t:dropTarget) {
         for (int i = top; i >= 0; i--) { // 후위 검색.
            if(storage[i] == t) { // 저장된 값과 삭제할 값이 같을 경우
               for (int j = i; j < top; j++) {
                  storage[j] = storage[j+1];
               }
               storage[top--] = 0;
            }
         }
      }
      
      if(lastTop == top ) {
         System.out.println("삭제하려는 데이터가 존재하지 않습니다.");
      } else {
         System.out.printf("자료가 %d개 삭제되었습니다.", lastTop - top);
      }
      
      printRemainSpace();
   }
}

public class ex3_1{
   public static void main(String[] args)   {
      Storage first=new Storage(10);
      
      first.drop(5,1);
      first.store(1,2,3,4,5,6,7,8,9,10,11);
      first.store(9,7);
      first.store(2,2,9);
      first.drop(2,9);
      first.store(3,5,5,9);
      first.store(8,9,4);
      first.store(1,2,3,4);
      first.store(5,1);
      first.drop(1);
      first.drop(3,4);
      first.drop(3,4,6);
      first.drop(5,8);
   }
}
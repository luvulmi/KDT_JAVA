import java.util.Iterator;
import java.util.LinkedList;

public class JAVA1209_3 {
	public static void main(String[] args) {
LinkedList<String> lkList = new LinkedList<String>();
		
		lkList.add("A");
		lkList.add("B");
		lkList.add("C");
		lkList.add("D");
		lkList.add("E");
		lkList.add("F");
		
		Iterator<String> iterator=lkList.iterator();	// iterator()를 통해 반복자 객체 리턴. 즉, 1차적인 순회를 통해 각 데이터의 후위 링크
														// 주소를 순차적인 형태로 배열하여 최초 데이터의 주소를 후위 링크 조소로 가지는 직전
														// 가상 데이터의 참조를 포함한 객체를 리턴.
		
		System.out.println(iterator.next());			// next() : 반복자 객체의 현 요소가 가지는 후위 링크 주소를 리턴하며 매 호출 시 마다 후위 링크 주소로
		System.out.println(iterator.next());			// 이동하여 해당 요소값 리턴. 15행의 반복자 객체를 통해 next()메서드를 호출함으로써 최초 요소에 대한
														// 직전 가상 데이터의 참조를 받아 가상의 현 요소가 가지는 후위 링크의 주소가 최초 요소를 가리킴으로써
														// 최초 요소의 값을 리턴.
		
		while(iterator.hasNext()) {						// boolean hasNext() : 현 요소에 대한 후위 링크 주소가 있는지 조사. next()로 조사 시
			System.out.println(iterator.next());		// 후위 링크 주소가 없다면 즉, 더 이상 요소값이 없다면 NoSuchElementException을
		}												// 발생시키므로 hasNext()메서드를 통해 미리 점검 필수.
		System.out.println();
		
		while(iterator.hasNext()) {						// 24행의 루프 완료 후 반복자의 참조는 맨 끝 요소를 가리키고 있으므로 루프 진입 자체가 불가.
			System.out.println(iterator.next());
		}
		System.out.println();
		
		
		
		iterator=lkList.iterator();						// 반복자를 재순회하기 위해서는 이와 같이 iterator()메서드를 통해 반복자 객체를 재 생성해야 함.
		while (iterator.hasNext()) {					// 24행에서 모든 데이터에 대한 접근이 끝난 후 자동으로 최초의 시점으로 포인터를 이동시키면 이렇게
			System.out.println(iterator.next());		// 객체를 재 생성해야 하는 불편함을 덜 수 있겠지만 그렇게 하지 않는 가장 큰 이유는 데이터를 단순히
		}												// 읽는 것은 문제가 되지 않으나 반복자 객체를 통한 데이터 순회 중 데이터를 삽입, 삭제하는 경우 그
		System.out.println();							// 데이터에 대한 후위 링크 주소가 추가, 삭제되어야 하는데 만일 반복자 객체를 그대로 사용한다면
														// 변경된 데이터에 대한 불법적인 접근이나 접근 불가로 이어지는 사태가 발생할 수 있어 당행과 같이
														// iterator()메서드를 통해 반복자 객체의 초기화 즉, 1차적인 데이터 재 순회를 통한 변경된
														// 데이터를 포함한 후위 링크 주소를 재조사해야함. 반복자는 모든 데이터에 대한 후위 링크 주소를
														// 객체화하여 저장하는 역할만을 담당하며, 호출 시 마다 포인터를 순차적으로 따라가면서 읽는 역할은
														// next()메서드가 담당. 따라서 최초 데이터에 대한 직전 가상 데이터의 참조는 반복자 객체를 통해
														// 직접 얻을 수 없고 그 객체에 대한 next()메서드를 통해서만 추출 가능함에 항상 주의.
		iterator=lkList.iterator();
		while(iterator.hasNext()) {
			String temp=iterator.next();
			if(temp=="B" || temp=="C") {
				iterator.remove();						// remove()	: 49행의 next()로 읽은 요소를 삭제.
			}
		}
		
		iterator=lkList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		
	}

}

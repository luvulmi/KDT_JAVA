
public class JAVA1208_13 {
	static String[] city = new String[] { "용인시", "목포시", "성남시", "속초시", "서울시", "수원시", "인천시", "부산시" };

	public static void main(String[] args) {
//		버스 운행 경로를 경유 도시별로 -> 구분자를 삽입하여 원하는 버스 운행 경로를 매번 생성해야 하는 상황을 가정

		String bus1 = "서울시->성남시->수원시->인천시->용인시";
		System.out.println("1.매번 무식하게 요렇게 나열하기 :" + bus1 + '\n');

		String bus2 = city[4] + "->" + city[2] + "->" + city[5] + "->" + city[6] + "->" + city[0];
		System.out.println("2.더 무식한 방법 : " + bus2 + '\n');

		String busRoute3 = assembleBuilder(4, 2, 5, 6, 0);
		System.out.println("3.배열 이용 : " + busRoute3 + "\n");
  
		String busRoute4 = assembleStringJoin(4, 2, 5, 6, 0);
		System.out.println("4.조인 배열 같이 : " + busRoute4 + "\n");

		System.out.println("5.마구 늘여놓기 : " + assembleStringJoin(2, 4, 2, 6, 2, 5, 3, 1, 3, 4, 2));

	}

	static String assembleBuilder(int... a) {
		StringBuilder busRoute = new StringBuilder(); // 문자열 조립을 위해 stringbuilder 활용.

		for (int i = 0; i < a.length; i++) {
			busRoute.append(city[a[i]]);
			if (i < a.length - 1)
				busRoute.append("->");
		}

		return busRoute.toString(); // String으로 직접 대입 불가하므로 toString메서드를 이용하여 변환하여 대입.
	}

	static String assembleStringJoin(int... a) {

		String busRoute = city[a[0]];

		for (int i = 0; i < a.length; i++) {
			busRoute = String.join("->", busRoute, city[a[i]]);
		}
		return busRoute;
	}
}

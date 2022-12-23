package jdbc02;

import java.util.List;

//** Controller
//=> 요청받아 -> 해당 서비스를 처리하고 -> 결과 출력.

public class StudentController {

	StudentService service = new StudentService();

	// 1. selectList
	public void selectList() {
//		service.selectList()의 처리결과를 받아 출력하는 작업.
		List<StudentVO> list = service.selectList();
		System.out.println("** Student List **");

		if (list != null) {
			// 낫널일 때 리스트 출력해야 하므로 조건문 걸기.
			for (StudentVO s : list) {
				System.out.println(s);
			} // for
		} else {
			System.out.println("** 출력할 자료가 없습니다. **");
		} // if

	} // selectList

	// 2. selectOne
	public void selectOne(StudentVO vo) {
		System.out.println("\n** Student Detail **");
		vo = service.selectOne(vo);
		if (vo != null) {
			System.out.println(vo);
		} else {
			System.out.println("** id에 해당하는 자료가 없습니다. **");
		}
	}// selectOne

	// 3. insert
	public void insert(StudentVO vo) {
		System.out.println("\n** Student insert **");
		if (service.insert(vo) > 0) {
			// insert 성공
			System.out.println("** insert 성공 **");
			// 성공 결과 출력
			selectOne(vo);
		} else {
			// insert 실패
			System.out.println("** insert 실패 **");
		}
	}// insert

	// 4. update
	public void update(StudentVO vo) {
		System.out.println("\n** Student update **");
		if (service.update(vo) > 0) {
			// update 성공
			System.out.println("** update 성공 **");
			// 성공 결과 출력
			selectOne(vo);
		} else {
			// update 실패
			System.out.println("** update 실패 **");
		}
	}// update

	// 5. delete
	public void delete(StudentVO vo) {
		System.out.println("\n** Student delete **");
		if (service.delete(vo) > 0) {
			// insert 성공
			System.out.println("** delete 성공 **");
		} else {
			// insert 실패
			System.out.println("** delete 실패 **");
		}
	}// delete
	
	// 6. group 통계
	public void groupTest() {
		List<GroupDTO> list = service.groupTest() ;
		if (list != null) {
			// 결과 출력
			for (GroupDTO j : list) {
				System.out.println(j);
			}
		} else {
			// 출력할 결과 없음
			System.out.println("** 출력할 조별 통계 없음 **");
		}
	} // groupTest
	
	// 7. Transacion Test
	public void transactionTest() {
		service.transactionTest();
	}		

	public static void main(String[] args) {
		// ** 기본 인스턴스 정의
		StudentController sc = new StudentController();
		StudentVO vo = new StudentVO();

		// 1. selectList : 목록 조회.
		sc.selectList();

		// 2. selectOne : Detail. 상세 조회.
		vo.setId("KYR"); // 찾고자 하는 ID 입력.
		sc.selectOne(vo);

		// 3. insert
		// => 입력 Data VO에 set해주어야함.
		vo.setId("apple");
		vo.setName("사과사과");
		vo.setAge(20);
		vo.setJno(4);
		vo.setInfo("insert test");
		vo.setPoint(111.33);
		vo.setBirthday("2001-01-01");
		sc.insert(vo);

		// 4. update
		// => 위의 입력한 apple의 name, point, birthday 수정하기
		vo.setId("apple");
		vo.setName("스티브잡스");
		vo.setPoint(300.99);
		vo.setBirthday("2002-02-02");
		sc.update(vo);

		// 5. delete
		vo.setId("apple");
		sc.delete(vo);
		
		// 6. group 통계
		// => GroupDTO 작성, Service, Dao
		sc.groupTest();
		
		// 7. Transacion Test
		sc.transactionTest();
		
		System.out.println("** Program 정상종료 **");

	}// main

}

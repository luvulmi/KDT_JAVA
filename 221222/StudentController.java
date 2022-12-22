package jdbc2;

import java.util.List;


// ** Controller
// => ��û�޾� -> �ش� ���񽺸� ó���ϰ� -> ��� ���.

public class StudentController {

	StudentService service = new StudentService();

	// 1. selectList
	public void selectList() {
//		service.selectList()�� ó������� �޾� ����ϴ� �۾�.
		List<StudentVO> list = service.selectList();
		System.out.println("** Student List **");

		if (list != null) {
			// ������ �� ����Ʈ ����ؾ� �ϹǷ� ���ǹ� �ɱ�.
			for (StudentVO s : list) {
				System.out.println(s);
			} // for
		} else {
			System.out.println("** ����� �ڷᰡ �����ϴ�. **");
		} // if

	} // selectList

	// 2. selectOne
	public void selectOne(StudentVO vo) {
		System.out.println("\n** Student Detail **");
		vo = service.selectOne(vo);
		if (vo != null) {
			System.out.println(vo);
		} else {
			System.out.println("** id�� �ش��ϴ� �ڷᰡ �����ϴ�. **");
		}
	}// selectOne

	// 3. insert
	public void insert(StudentVO vo) {
		System.out.println("\n** Student insert **");
		if (service.insert(vo) > 0) {
			// insert ����
			System.out.println("** insert ���� **");
			// ���� ��� ���
			selectOne(vo);			
		} else {
			// insert ����
			System.out.println("** insert ���� **");
		}
	}// insert
	
	// 4. update
	public void update(StudentVO vo) {
		System.out.println("\n** Student update **");
		if (service.update(vo) > 0) {
			// update ����
			System.out.println("** update ���� **");
			// ���� ��� ���
			selectOne(vo);			
		} else {
			// update ����
			System.out.println("** update ���� **");
		}
	}// update
	
	// 5. delete
	public void delete(StudentVO vo) {
		System.out.println("\n** Student delete **");
		if (service.delete(vo) > 0) {
			// insert ����
			System.out.println("** delete ���� **");
		} else {
			// insert ����
			System.out.println("** delete ���� **");
		}
	}// delete

	public static void main(String[] args) {
		// ** �⺻ �ν��Ͻ� ����
		StudentController sc = new StudentController();
		StudentVO vo = new StudentVO();

		// 1. selectList : ��� ��ȸ.
		sc.selectList();

		// 2. selectOne : Detail. �� ��ȸ.
		vo.setId("KYR"); // ã���� �ϴ� ID �Է�.
		sc.selectOne(vo);

		// 3. insert
		// => �Է� Data VO�� set���־����.
		vo.setId("apple");
		vo.setName("������");
		vo.setAge(20);
		vo.setJno(10);
		vo.setInfo("insert test");
		vo.setPoint(111.33);
		vo.setBirthday("2001-01-01");
		sc.insert(vo);

		// 4. update
		// => ���� �Է��� apple�� name, point, birthday �����ϱ�
		vo.setId("apple");
		vo.setName("��Ƽ���⽺");
		vo.setPoint(300.99);
		vo.setBirthday("2002-02-02");
		sc.update(vo);

		// 5. delete		
		vo.setId("apple");
		sc.delete(vo);

	}// main

}

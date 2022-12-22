package jdbc2;

// ** VO class Ȱ�� ����

public class Ex01_VOTest {
	public static void main(String[] args) {
		// 1. �ʱ�ȭ
		// => ������ : ���� �� 1ȸ�� ��밡��.
		// �߿��ڷ� ��ȣ�ϴ� ��� �����ڷ� �ʱ�ȭ �ϰ�, setter �������� ����(�����Ұ�)
		StudentVO vo1 = new StudentVO("banana","����",22,9,"������ �ʱ�ȭ",123.45,"2001-10-10");
		System.out.println("** vo1 id => " + vo1.getId());
		System.out.println("** vo1 name => " + vo1.getName());
		
		// => setter : ������ ȣ�� ����.
		StudentVO vo2 = new StudentVO();
		vo2.setId("apple");
		vo2.setName("����");
		vo2.setAge(27);
		vo2.setJno(7);
		vo2.setInfo("setter�� �ʱ�ȭ");
		vo2.setPoint(300.55);
		vo2.setBirthday("1996-09-09") ;
		System.out.println("** vo2 id => " + vo2.getId());
		System.out.println("** vo2 name => " + vo2.getName());
		
		vo2.country = "USA";
		System.out.println("** vo2 country => "+ vo2.country);
		System.out.println("** vo2 country => "+ vo1.country);
		
		// 2. Ȯ�� & ��� 
		// => getter / toString()
		System.out.println("** vo1 toString => "+ vo1.toString());
		System.out.println("** vo2 toString => "+ vo2.toString());
		
		// toString() : Object�� ���ǵǾ�, �ν��Ͻ� ������ �ּҰ��� String Type���� return.
		//			  : ��¹����� ȣ�� �� �޼���� ���� ����.
		// 			  : ��¹����� �ν��Ͻ����� ����ϸ� toString() �޼��� �ڵ� ȣ��.
		Ex01_VOTest ex01 = new Ex01_VOTest();
		System.out.println("** Ex01 toString => "+ ex01.toString());
		System.out.println("** Ex01 toString ���� => "+ ex01);
		System.out.println("** vo1 toString ���� => "+ vo1);
		System.out.println("** vo2 toString ���� => "+ vo2);
		
		// 3. static �ɹ�
		// => �ν��Ͻ��� �����ϴ� �ǹ̰�����, Ŭ���������� �����ϵ�����  
		// => �ٶ��������� ������ ������ ���� ����
		System.out.println("** vo1 country => "+ vo1.country);
		
	} // main
} // class

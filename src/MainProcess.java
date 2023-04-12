///////////////////////////////////////////////
/*
  �й� : 2017315001
  �а� : AI����Ʈ����
  �̸� : ������
  ������Ʈ �� : �������б� �߾ӵ����� Ȱ��ȭ ���� ���α׷�
  �Ⱓ : 2021.06.10 ~ 2021.06.16
                                             */
///////////////////////////////////////////////
/*
������Ÿ�� ����
���� �޴�(GUI) >> ��, html�� �̿��Ͽ� �� ���� GUI���� ����
UserDB�� �̿��Ͽ� �α��� �ý��� ����


                                             */
///////////////////////////////////////////////


package libraryProgram_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainProcess {
	
	static UserDB userDB = new UserDB();

	static String MainScreen_NotLogin(Acount persnal) {
		Scanner input = new Scanner(System.in);
		
		String fieldID = "{field ID}";
		String fieldPW = "{field PW}";
		
		String inputID = null;
		String inputPW = null;
		
		while(true) {
			if(inputID != null) {
				fieldID = inputID;
			}
			if(inputPW != null) {
				fieldPW = inputPW;
			}
			
			System.out.println("############################");
			System.out.println("     �������б� �߾� ������     ");
			System.out.println("############################");
			System.out.println("           Login           ");
			System.out.println("");
			System.out.printf("     ID : %s       \n", fieldID);
			System.out.printf("     PW : %s       \n", fieldPW);
			System.out.println("");
			System.out.println("############################");
			System.out.println("     1. å �뿩 �� �ݳ�       ");
			System.out.println("     2. â���н����� �뿩      ");
			System.out.println("     3. ���� Ȱ��            ");
			System.out.println("     4. Ȱ�� ���� ����        ");
			System.out.println("     5. ��ú���             ");
			System.out.println("     6. �� ���� �̺�Ʈ        ");
			System.out.println("     7. ���� (���� �Է�)      ");
			System.out.println("############################");
			if (inputID != null) {
				System.out.print("�α����� PW : ");
				inputPW = input.next();
				if(1 == userDB.LogIn(inputID, inputPW)) {
					persnal = new Acount(inputID);
					return "";
				}
				else if(inputPW.equals("����"))
					return "����";
			}
			else
				System.out.print("�α����� ID : ");
			inputID = input.next();
			if (inputID.equals("����"))
				return "����";
		}
	}
	
	static String MainScreen_Login(char grade, int mpoint, int spoint, int apoint, String borrowlist, String returndate) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("############################");
		System.out.println("     �������б� �߾� ������     ");
		System.out.println("############################");
		System.out.println("          Dashboard        ");
		System.out.printf("    Membership : %c(%d)\n", grade, mpoint);
		System.out.printf("  ���� ����Ʈ : %d Ȱ���� : %d\n", spoint, apoint);
		System.out.printf("  ���� å : %s\n", borrowlist);
		System.out.printf("  ����� �ݳ��� : %s\n", returndate);
		System.out.println("############################");
		System.out.println("     1. å �뿩 �� �ݳ�       ");
		System.out.println("     2. â���н����� �뿩      ");
		System.out.println("     3. ���� Ȱ��            ");
		System.out.println("     4. Ȱ�� ���� ����        ");
		System.out.println("     5. ��ú���             ");
		System.out.println("     6. �� ���� �̺�Ʈ        ");
		System.out.println("     7. ���� (���� �Է�)      ");
		System.out.println("############################");
		System.out.println(" �Է� : ");
		return input.next();
	}
	
	static void BookBorrowScreen() {
		System.out.println("############################");
		System.out.println("     �������б� �߾� ������     ");
		System.out.println("############################");
		System.out.println("          å ������          ");
		System.out.println("     1. å�˻�       ");
		System.out.println("     2. å ������       ");
		System.out.println("     3. å �ݳ�       ");
		System.out.println("     4. �ڷΰ���       ");
		System.out.println("############################");
		System.out.println("     1. å �뿩 �� �ݳ�       ");
		System.out.println("     2. â���н����� �뿩      ");
		System.out.println("     3. ���� Ȱ��            ");
		System.out.println("     4. Ȱ�� ���� ����        ");
		System.out.println("     5. ��ú���             ");
		System.out.println("     6. �� ���� �̺�Ʈ        ");
		System.out.println("     7. ���� (���� �Է�)      ");
		System.out.println("############################");
		System.out.printf(" �Է� : ");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Acount persnal = new Acount("nite100");
		System.out.println(persnal.ID);
		Scanner sc = new Scanner(System.in);
		
		String input = "";

		System.out.println(userDB.SignUp("sdafg", "dds", "24124", "�䤱��", UserType.���л�)); // ���� ���� �޼ҵ� >> ���� ���� ��ȯ (ID�� SID ���� ���� Ȯ��)
		userDB.LogIn("nite100", "1234"); // ��й�ȣ ����ġ
		userDB.LogIn("nite100", "1245"); // �α��� ����
		userDB.LogIn("nitsd", "1234"); // ���� ����
		
		input = MainScreen_NotLogin(persnal);
		
		while(!input.equals("����")) {
			
			input = MainScreen_Login('A', 22785, 370000, 37000, "���� , ��", "2021.07.01"); // �ð������� ������ ���� ������ �Է��Ͽ� ������ Ÿ�� ����
			BookBorrowScreen(); // �ð������� ������ ���������� ������ Ÿ�� ����
			input = sc.next();
		}
		System.out.println("���α׷��� �����մϴ�.");
		
		System.out.println("�̰������� GUI�� �����Ͽ� ������ ��ɵ��� �����ϵ��� �ϰڽ��ϴ�.");
		System.out.printf("���� �α��� �� ������ ����� ��� : %s\n", persnal.getMembership().getGrade());
		System.out.printf("���� �α��� �� ������ ����� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("�����"));
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("Ȱ��"));
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("����"));
		System.out.println();
		
		System.out.printf("���� Ȱ���� ���� ���� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("Ȱ���� ���� ���ϸ��� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("�ڳ�ŷ Ŀ�� ���� ���� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("���� ���͵� Ȱ�� ������ ���� ����Ʈ ��� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		System.out.printf("Ư�� Ȱ���� ���� ����� ����Ʈ ȹ�� : %d\n", persnal.getMembership().AddMembershipPoint(10000));

		persnal.getMembership().checkGrade();
		
		System.out.printf("���� �α��� �� ������ ����� ��� : %s\n", persnal.getMembership().getGrade());
		System.out.printf("���� �α��� �� ������ ����� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("�����"));
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("Ȱ��"));
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("����"));
		System.out.println();
		
		System.out.printf("Ư�� Ȱ���� ���� ����� ����Ʈ ȹ�� : %d\n", persnal.getMembership().AddMembershipPoint(10000));
		System.out.println();
		
		persnal.getMembership().checkGrade();
		
		System.out.printf("���� �α��� �� ������ ����� ��� : %s\n", persnal.getMembership().getGrade());
		System.out.printf("���� �α��� �� ������ ����� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("�����"));
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("Ȱ��"));
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("����"));
		System.out.println();
		
		System.out.printf("���� Ȱ���� ���� ���� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("Ȱ���� ���� ���ϸ��� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("�ڳ�ŷ Ŀ�� ���� ���� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("���� ���͵� Ȱ�� ������ ���� ����Ʈ ��� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		System.out.printf("Ư�� Ȱ���� ���� ����� ����Ʈ ȹ�� : %d\n", persnal.getMembership().AddMembershipPoint(10000));
		System.out.println();
		
		persnal.getMembership().checkGrade();
		
		System.out.printf("���� �α��� �� ������ ����� ��� : %s\n", persnal.getMembership().getGrade());
		System.out.printf("���� �α��� �� ������ ����� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("�����"));
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("Ȱ��"));
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().CheckPoint("����"));
		System.out.println();
		
		System.out.printf("���� Ȱ���� ���� ���� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("Ȱ���� ���� ���ϸ��� ȹ�� : 50000\n");
		System.out.printf("���� �α��� �� ������ ����� Ȱ�� ����Ʈ : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("�ڳ�ŷ Ŀ�� ���� ���� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("���� ���͵� Ȱ�� ������ ���� ����Ʈ ��� : 3000\n");
		System.out.printf("���� �α��� �� ������ ����� ���� ����Ʈ : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		
	}

}

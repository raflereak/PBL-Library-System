///////////////////////////////////////////////
/*
  학번 : 2017315001
  학과 : AI소프트웨어
  이름 : 김태훈
  프로젝트 명 : 선문대학교 중앙도서관 활성화 예시 프로그램
  기간 : 2021.06.10 ~ 2021.06.16
                                             */
///////////////////////////////////////////////
/*
프로토타입 구현
메인 메뉴(GUI) >> 앱, html을 이용하여 더 좋은 GUI구현 가능
UserDB를 이용하여 로그인 시스템 구축


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
			System.out.println("     선문대학교 중앙 도서관     ");
			System.out.println("############################");
			System.out.println("           Login           ");
			System.out.println("");
			System.out.printf("     ID : %s       \n", fieldID);
			System.out.printf("     PW : %s       \n", fieldPW);
			System.out.println("");
			System.out.println("############################");
			System.out.println("     1. 책 대여 및 반납       ");
			System.out.println("     2. 창의학습공간 대여      ");
			System.out.println("     3. 장학 활동            ");
			System.out.println("     4. 활동 개설 참가        ");
			System.out.println("     5. 대시보드             ");
			System.out.println("     6. 이 주의 이벤트        ");
			System.out.println("     7. 종료 (종료 입력)      ");
			System.out.println("############################");
			if (inputID != null) {
				System.out.print("로그인중 PW : ");
				inputPW = input.next();
				if(1 == userDB.LogIn(inputID, inputPW)) {
					persnal = new Acount(inputID);
					return "";
				}
				else if(inputPW.equals("종료"))
					return "종료";
			}
			else
				System.out.print("로그인중 ID : ");
			inputID = input.next();
			if (inputID.equals("종료"))
				return "종료";
		}
	}
	
	static String MainScreen_Login(char grade, int mpoint, int spoint, int apoint, String borrowlist, String returndate) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("############################");
		System.out.println("     선문대학교 중앙 도서관     ");
		System.out.println("############################");
		System.out.println("          Dashboard        ");
		System.out.printf("    Membership : %c(%d)\n", grade, mpoint);
		System.out.printf("  장학 포인트 : %d 활동력 : %d\n", spoint, apoint);
		System.out.printf("  빌린 책 : %s\n", borrowlist);
		System.out.printf("  가까운 반납일 : %s\n", returndate);
		System.out.println("############################");
		System.out.println("     1. 책 대여 및 반납       ");
		System.out.println("     2. 창의학습공간 대여      ");
		System.out.println("     3. 장학 활동            ");
		System.out.println("     4. 활동 개설 참가        ");
		System.out.println("     5. 대시보드             ");
		System.out.println("     6. 이 주의 이벤트        ");
		System.out.println("     7. 종료 (종료 입력)      ");
		System.out.println("############################");
		System.out.println(" 입력 : ");
		return input.next();
	}
	
	static void BookBorrowScreen() {
		System.out.println("############################");
		System.out.println("     선문대학교 중앙 도서관     ");
		System.out.println("############################");
		System.out.println("          책 빌리기          ");
		System.out.println("     1. 책검색       ");
		System.out.println("     2. 책 빌리기       ");
		System.out.println("     3. 책 반납       ");
		System.out.println("     4. 뒤로가기       ");
		System.out.println("############################");
		System.out.println("     1. 책 대여 및 반납       ");
		System.out.println("     2. 창의학습공간 대여      ");
		System.out.println("     3. 장학 활동            ");
		System.out.println("     4. 활동 개설 참가        ");
		System.out.println("     5. 대시보드             ");
		System.out.println("     6. 이 주의 이벤트        ");
		System.out.println("     7. 종료 (종료 입력)      ");
		System.out.println("############################");
		System.out.printf(" 입력 : ");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Acount persnal = new Acount("nite100");
		System.out.println(persnal.ID);
		Scanner sc = new Scanner(System.in);
		
		String input = "";

		System.out.println(userDB.SignUp("sdafg", "dds", "24124", "긴ㅁㄴ", UserType.대학생)); // 계정 생성 메소드 >> 성공 여부 반환 (ID와 SID 동일 인자 확인)
		userDB.LogIn("nite100", "1234"); // 비밀번호 불일치
		userDB.LogIn("nite100", "1245"); // 로그인 성공
		userDB.LogIn("nitsd", "1234"); // 계정 없음
		
		input = MainScreen_NotLogin(persnal);
		
		while(!input.equals("종료")) {
			
			input = MainScreen_Login('A', 22785, 370000, 37000, "개미 , 신", "2021.07.01"); // 시간부족의 이유로 직접 데이터 입력하여 프로토 타입 구현
			BookBorrowScreen(); // 시간부족의 이유로 임의적으로 프로토 타입 구현
			input = sc.next();
		}
		System.out.println("프로그램을 종료합니다.");
		
		System.out.println("이곳에서는 GUI를 제외하여 구현한 기능들을 제시하도록 하겠습니다.");
		System.out.printf("현재 로그인 된 계정의 멤버십 등급 : %s\n", persnal.getMembership().getGrade());
		System.out.printf("현재 로그인 된 계정의 멤버십 포인트 : %d\n", persnal.getMembership().CheckPoint("멤버십"));
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().CheckPoint("활동"));
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().CheckPoint("장학"));
		System.out.println();
		
		System.out.printf("장학 활동을 통한 점수 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("활동을 통한 마일리지 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("코나킹 커피 음료 구매 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("정기 스터디 활동 개설을 위한 포인트 사용 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		System.out.printf("특수 활동을 통한 멤버십 포인트 획득 : %d\n", persnal.getMembership().AddMembershipPoint(10000));

		persnal.getMembership().checkGrade();
		
		System.out.printf("현재 로그인 된 계정의 멤버십 등급 : %s\n", persnal.getMembership().getGrade());
		System.out.printf("현재 로그인 된 계정의 멤버십 포인트 : %d\n", persnal.getMembership().CheckPoint("멤버십"));
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().CheckPoint("활동"));
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().CheckPoint("장학"));
		System.out.println();
		
		System.out.printf("특수 활동을 통한 멤버십 포인트 획득 : %d\n", persnal.getMembership().AddMembershipPoint(10000));
		System.out.println();
		
		persnal.getMembership().checkGrade();
		
		System.out.printf("현재 로그인 된 계정의 멤버십 등급 : %s\n", persnal.getMembership().getGrade());
		System.out.printf("현재 로그인 된 계정의 멤버십 포인트 : %d\n", persnal.getMembership().CheckPoint("멤버십"));
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().CheckPoint("활동"));
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().CheckPoint("장학"));
		System.out.println();
		
		System.out.printf("장학 활동을 통한 점수 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("활동을 통한 마일리지 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("코나킹 커피 음료 구매 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("정기 스터디 활동 개설을 위한 포인트 사용 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		System.out.printf("특수 활동을 통한 멤버십 포인트 획득 : %d\n", persnal.getMembership().AddMembershipPoint(10000));
		System.out.println();
		
		persnal.getMembership().checkGrade();
		
		System.out.printf("현재 로그인 된 계정의 멤버십 등급 : %s\n", persnal.getMembership().getGrade());
		System.out.printf("현재 로그인 된 계정의 멤버십 포인트 : %d\n", persnal.getMembership().CheckPoint("멤버십"));
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().CheckPoint("활동"));
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().CheckPoint("장학"));
		System.out.println();
		
		System.out.printf("장학 활동을 통한 점수 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().AddScholarshipPoint(50000));
		System.out.println();
		
		System.out.printf("활동을 통한 마일리지 획득 : 50000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 활동 포인트 : %d\n", persnal.getMembership().AddActivityPoint(50000));
		System.out.println();
		
		System.out.printf("코나킹 커피 음료 구매 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseScholarshipPoint(3000));
		System.out.println();
		
		System.out.printf("정기 스터디 활동 개설을 위한 포인트 사용 : 3000\n");
		System.out.printf("현재 로그인 된 계정의 멤버십 장학 포인트 : %d\n", persnal.getMembership().UseActivityPoint(3000));
		System.out.println();
		
		
	}

}

package libraryProgram_1;

enum Grade{
	F, // 3000
	D, // 5000
	C, // 10000
	B, // 20000
	A, // 30000
	S, // 50000
	VIP
}

public class Membership {
	Grade MembershipGrade;
	int MembershipPoint; // 멤버십 등급 책정 포인트
	int ActivityPoint; // 활동 마일리지 포인트
	int ScholarshipPoint; // 장학금 포인트
	
	Membership(){
		this.MembershipGrade = Grade.F;
		this.MembershipPoint = 0;
		this.ActivityPoint = 0;
		this.ScholarshipPoint = 0;
	}
	
	String getGrade() { // 멤버십 등급을 문자열로 반환
		return this.MembershipGrade.toString();
	}
	
	int CheckPoint(String type) { // 현재 포인트 확인.
		switch(type) {
		case "멤버십":
			return this.MembershipPoint;
		case "활동":
			return this.ActivityPoint;
		case "장학":
			return this.ScholarshipPoint;
		}
		return 0;
	}
	
	int AddMembershipPoint(int point) { // 멤버십 포인트 추가 및 변경된 포인트 반환
		this.MembershipPoint += point;
		return this.MembershipPoint;
	}
	
	int AddActivityPoint(int point) { // 활동 마일리지 포인트 추가 및 변경된 포인트 반환
		switch(this.MembershipGrade) {
		case F:
			this.ActivityPoint += point * 1.05f;
			break;
		case D:
			this.ActivityPoint += point * 1.1f;
			break;
		case C:
			this.ActivityPoint += point * 1.15f;
			break;
		case B:
			this.ActivityPoint += point * 1.2f;
			break;
		case A:
			this.ActivityPoint += point * 1.25f;
			break;
		case S:
			this.ActivityPoint += point * 1.3f;
			break;
		case VIP:
			this.ActivityPoint += point * 1.35f;
			break;
		}
		return this.ActivityPoint;
	}
	
	int UseActivityPoint(int point) { // 활동 마일리지 포인트 사용 및 변경된 포인트 반환
		this.ActivityPoint -= point;
		return this.ActivityPoint;
	}
	
	int AddScholarshipPoint(int point) { // 장학금 포인트 추가 및 멤버십 등급별 보너스 추가 변경된 포인트 반환
		switch(this.MembershipGrade) {
		case F:
			this.ScholarshipPoint += point * 1.0005f;
			break;
		case D:
			this.ScholarshipPoint += point * 1.001f;
			break;
		case C:
			this.ScholarshipPoint += point * 1.0015f;
			break;
		case B:
			this.ScholarshipPoint += point * 1.002f;
			break;
		case A:
			this.ScholarshipPoint += point * 1.0025f;
			break;
		case S:
			this.ScholarshipPoint += point * 1.003f;
			break;
		case VIP:
			this.ScholarshipPoint += point * 1.0035f;
			break;
		}
		return this.ScholarshipPoint;
	}

	int UseScholarshipPoint(int point) { // 장학금 포인트 사용 및 등급별 할인율 적용 변경된 포인트 반환
		switch(this.MembershipGrade) {
		case F:
			this.ScholarshipPoint -= point * 0.995f;
			break;
		case D:
			this.ScholarshipPoint -= point * 0.99f;
			break;
		case C:
			this.ScholarshipPoint -= point * 0.985f;
			break;
		case B:
			this.ScholarshipPoint -= point * 0.98f;
			break;
		case A:
			this.ScholarshipPoint -= point * 0.975f;
			break;
		case S:
			this.ScholarshipPoint -= point * 0.97f;
			break;
		case VIP:
			this.ScholarshipPoint -= point * 0.965f;
			break;
		}
		return this.ScholarshipPoint;
	}
	
	void checkGrade() {
		switch(this.MembershipPoint){
		case 0:
		case 3000:
			this.MembershipGrade = Grade.D;
			break;
		case 5000:
			this.MembershipGrade = Grade.C;
			break;
		case 10000:
			this.MembershipGrade = Grade.B;
			break;
		case 20000:
			this.MembershipGrade = Grade.A;
			break;
		case 30000:
			this.MembershipGrade = Grade.S;
			break;
		case 50000:
			this.MembershipGrade = Grade.VIP;
			break;
		}
	}
}

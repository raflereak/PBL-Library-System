package libraryProgram_1;

public class Book { // 책 클래스로 책의 정보와 빌릴 수 있는지 없는지 여부를 파악할 수 있는 변수가 있다.
	String BookName;
	String BookAuthor;
	int BID;
	boolean BorrowStatus = false;
	Acount BorrowUser;
	
	boolean BorrowBook(Acount user) { // 책을 빌리는 메소드
		if(this.BorrowStatus == false) { // 책이 대여중인지 파악하는 if문
			this.BorrowUser = user;
			this.BorrowStatus = true;
			return true;
		}
		else {
			return false;
		}
	}
	void ReturnBook() { // 책을 반납하는 메소드
		this.BorrowStatus = false;
		this.BorrowUser = null;
	}
}

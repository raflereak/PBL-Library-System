package libraryProgram_1;

public class Book { // å Ŭ������ å�� ������ ���� �� �ִ��� ������ ���θ� �ľ��� �� �ִ� ������ �ִ�.
	String BookName;
	String BookAuthor;
	int BID;
	boolean BorrowStatus = false;
	Acount BorrowUser;
	
	boolean BorrowBook(Acount user) { // å�� ������ �޼ҵ�
		if(this.BorrowStatus == false) { // å�� �뿩������ �ľ��ϴ� if��
			this.BorrowUser = user;
			this.BorrowStatus = true;
			return true;
		}
		else {
			return false;
		}
	}
	void ReturnBook() { // å�� �ݳ��ϴ� �޼ҵ�
		this.BorrowStatus = false;
		this.BorrowUser = null;
	}
}

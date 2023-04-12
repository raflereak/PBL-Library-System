package libraryProgram_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

enum UserType{
	���л�,
	���п���,
	����
}
public class Acount {
	String ID;
	String PW;
	String SID;
	String NAME;
	String userType;
	UserType usertype;
	Membership Membership = new Membership();
	ArrayList<String[]> DB = new ArrayList<String[]>();
	
	boolean OnLine = false;
	
	Acount(String id){
		this.ID = id;
		try{
            //���� ��ü ����
            File file = new File("src\\libraryProgram_1\\UserDataBase.txt"); // �ش� ��ο� �����ϴ� �����ͺ��̽� ���� �ҷ�����
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){ // ���͸� �������� ������ ������� ����
            	String[] tempLine;
            	tempLine = line.split(" "); // " "�� �ִ� ��� �߶� �� �迭 �������� ����
                this.DB.add(tempLine); // �迭 ����
                bufReader.close();
            }
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
		for (int i = 0; i < DB.size(); i++) {
			System.out.println("debug");
			if(id.equals(DB.get(i)[0])) {
				this.PW = DB.get(i)[1];
				this.SID = DB.get(i)[2];
				this.NAME = DB.get(i)[3];
				this.userType = DB.get(i)[4];
				this.usertype = UserType.valueOf(userType);
				System.out.println(usertype.name());
				this.Membership = new Membership();
			}
		}
	}
	
	boolean Login(String id, String pw) {
		if(this.ID == id) {
			if(this.PW == pw)
				this.OnLine = true;
				return true;
		}
		return false;
	}
	
	Membership getMembership() {
		return this.Membership;
	}
	
	void getType() {
		System.out.println(usertype.name());
	}
}

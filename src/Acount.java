package libraryProgram_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

enum UserType{
	대학생,
	대학원생,
	교수
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
            //파일 객체 생성
            File file = new File("src\\libraryProgram_1\\UserDataBase.txt"); // 해당 경로에 존재하는 데이터베이스 파일 불러오기
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){ // 엔터를 기준으로 나누는 방식으로 진행
            	String[] tempLine;
            	tempLine = line.split(" "); // " "가 있는 경우 잘라낸 후 배열 형식으로 삽입
                this.DB.add(tempLine); // 배열 삽입
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

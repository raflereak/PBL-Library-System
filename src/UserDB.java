package libraryProgram_1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


public class UserDB {
	ArrayList<String[]> DB = new ArrayList<String[]>();
	
	UserDB(){
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
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
	}
	
	int LogIn(String id, String pw) { // 유저 데이터 베이스에서 ID를 검색하고, 비밀번호 매칭하는 메소드
		for(int i = 0; i < DB.size(); i++) {
			if(DB.get(i)[0].equals(id)) { // ID 검색
				if(DB.get(i)[1].equals(pw)) { // PW 일치 여부 파악
					return 1; // 로그인 성공 반환
				}
				else {
					return 2; // 패스워드 불일치 반환
				}
			}
		}
		return 0; // 계정 없음 반환
	}
	
	int SignUp(String id, String pw, String sid, String name, UserType type) { // 계정 생성을 위한 메소드
		for(int i = 0; i < DB.size(); i++) {
			if(DB.get(i)[0].equals(id)) {
				return 1; // 동일한 id가 존재하면 반환
			}
			if(DB.get(i)[2].equals(sid)) {
				return 2; // 동일한 학번이 존재하면 반환
			}
		}
		String[] newAcount = {id, pw, sid, name, type.name()};
		this.DB.add(newAcount);
		try {
			File file = new File("src\\libraryProgram_1\\UserDataBase.txt"); // 해당 경로에 존재하는 데이터베이스 파일 불러오기
			FileWriter temp = new FileWriter(file, true);
			
			temp.write("\n"); // 데이터 정렬을 위해 내려쓰기 입력
			for (int n = 0; n < 5; n++) { // 각 데이터들 입력 분류를 위해 " " 공백 삽입
				temp.write(newAcount[n] + " ");
			}
			
			temp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

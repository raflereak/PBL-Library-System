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
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
	}
	
	int LogIn(String id, String pw) { // ���� ������ ���̽����� ID�� �˻��ϰ�, ��й�ȣ ��Ī�ϴ� �޼ҵ�
		for(int i = 0; i < DB.size(); i++) {
			if(DB.get(i)[0].equals(id)) { // ID �˻�
				if(DB.get(i)[1].equals(pw)) { // PW ��ġ ���� �ľ�
					return 1; // �α��� ���� ��ȯ
				}
				else {
					return 2; // �н����� ����ġ ��ȯ
				}
			}
		}
		return 0; // ���� ���� ��ȯ
	}
	
	int SignUp(String id, String pw, String sid, String name, UserType type) { // ���� ������ ���� �޼ҵ�
		for(int i = 0; i < DB.size(); i++) {
			if(DB.get(i)[0].equals(id)) {
				return 1; // ������ id�� �����ϸ� ��ȯ
			}
			if(DB.get(i)[2].equals(sid)) {
				return 2; // ������ �й��� �����ϸ� ��ȯ
			}
		}
		String[] newAcount = {id, pw, sid, name, type.name()};
		this.DB.add(newAcount);
		try {
			File file = new File("src\\libraryProgram_1\\UserDataBase.txt"); // �ش� ��ο� �����ϴ� �����ͺ��̽� ���� �ҷ�����
			FileWriter temp = new FileWriter(file, true);
			
			temp.write("\n"); // ������ ������ ���� �������� �Է�
			for (int n = 0; n < 5; n++) { // �� �����͵� �Է� �з��� ���� " " ���� ����
				temp.write(newAcount[n] + " ");
			}
			
			temp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

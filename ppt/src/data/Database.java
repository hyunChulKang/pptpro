package data;

import java.util.ArrayList;

import vo.UserVO;

public class Database {
	/*-----------------------------------------*/			//싱글톤
private static Database instance;
	
	private Database(){}
	
	public static Database getInstance(){
		if(instance == null){
			instance =new Database();
		}
		return instance;
	}
	/*-----------------------------------------*/	
	public ArrayList<UserVO> tb_user =new ArrayList<>(); 	//한개의 계정의 VO 클래스를 ArrayList에 저장한다.
	
	{
		UserVO user =new UserVO();			//기본적인 데이터를 미리 넣어두고 싶을때 만들어 놓은것
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		tb_user.add(user);
	}
	
}

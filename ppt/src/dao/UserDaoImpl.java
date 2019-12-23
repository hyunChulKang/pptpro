package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.UserVO;
import data.Database;

public class UserDaoImpl implements UserDao{
	/*-----------------------------------------*/
	private static UserDaoImpl instance;				//싱클톤
	
	private UserDaoImpl(){}
	
	public static UserDaoImpl getInstance(){
		if(instance == null){
			instance =new UserDaoImpl();
		}
		return instance;
	}
	/*-----------------------------------------*/
	Database database =Database.getInstance();
	
	
	@Override
	public UserVO selectUser(String key, String value) {		//--UserDao의 추상메서드  구현부분 
		for(int i =0; i < database.tb_user.size(); i++){
			UserVO user =database.tb_user.get(i);
			
			if(key.endsWith("ID")){								//user테이블에서 한줄씩검사를 하다가 id가  현재 ID값과 만나면 return을해준다.
				if(user.getId().equals(value)){					//key를 넘겨주는 곳에 따라 검색 하는게 달라짐 id로 넘기면 id검색 name으로 넘기면 name을 검색
					return user;
				}
			}else if(key.equals("NAME")){						//user테이블에서 한줄씩검사를 하다가 name이  현재 ID값과 만나면 return을해준다.
				if(user.getName().equals(value)){
					return user;
				}
				
			}
		}
		return null;
	}

	@Override
	public void insertUser(UserVO user) {									//
		database.tb_user.add(user);
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) {				//id 와 pw가 일치하는 user를 return
		UserVO rtnUser =null;
		for(int i =0; i<database.tb_user.size(); i++){						
			UserVO user =database.tb_user.get(i);
			boolean flag =true;
			Set<String> keys =param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("ID")){
					if(!user.getId().equals(value)) flag =false;
				}else if (key.equals("PASSWORD")){
					if(!user.getPassword().equals(value)) flag =false;
				}
			}
			if(flag) rtnUser =user;
		}
		
		return rtnUser;
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		
		return database.tb_user;
	}

}

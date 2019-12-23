package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVO;

public interface UserDao {
	
	UserVO selectUser(String key, String value);			//VO타입으로  매개변수 key와 value를  selectUser에 담는다.  

	void insertUser(UserVO user);						

	UserVO selectUser(HashMap<String, String> param);

	ArrayList<UserVO> selectUserList();

	
	
	
	
}

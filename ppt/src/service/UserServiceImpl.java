package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class UserServiceImpl implements UserService{

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}											//객체생성 할수 없게하기위한 생성자 
	
	public static UserServiceImpl getInstance(){
		if(instance == null){
			instance =new UserServiceImpl();
		}
		return instance;
	}
	
	UserDao userDao =UserDaoImpl.getInstance();							//UerDao을 사용하기 위해 
	
	@Override
	public void join() {												//회원 가입
		Scanner s =new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id =s.nextLine();
		System.out.print("비밀번호 : ");
		String password =s.nextLine();
		System.out.print("이름 : ");
		String name =s.nextLine();
		
		UserVO user = new UserVO();
		
		user.setId(id);													//VO를 통해 유효성 검사
		user.setPassword(password);
		user.setName(name);
		
		UserVO userCheck = userDao.selectUser("ID", user.getId());		//selectUser로 넘겨 받아서  중복확인
		
		if(userCheck == null){
		 userDao.insertUser(user);
		 System.out.println("가입해주셔서 감사합니다.");
		}else{
			System.out.println("아이디 중복");
		}
	}

	@Override
	public void login() {
		//로그인
		Scanner s = new Scanner(System.in);
		
		System.out.println("아이디: ");
		String id = s.nextLine();
		System.out.println("비밀번호: ");
		String password = s.nextLine();
		
		HashMap<String, String>param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user =userDao.selectUser(param);		
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
		}else{
			Session.loginUser =user; 		//로그인이 되었을시  세션에 user를 저장
			System.out.println("로그인 성공!!");
			System.out.println(user.getName()+ "님 환영합니다.");
		}		
	}

	@Override
	public void userList() {
		ArrayList<UserVO> userList =userDao.selectUserList();
		
		System.out.println("------------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("------------------------------");
		for(int i =userList.size() -1; 0<= i; i--){
			UserVO user =userList.get(i);
			System.out.println(i + 1 + "\t"+ user.getId()
								+ "\t" + user.getName());
		}
		System.out.println("-------------------------------------");
	}

	
}

package controller;

import java.util.Scanner;

import service.UserService;
import service.UserServiceImpl;

public class Controller {
	
	UserService userService = UserServiceImpl.getInstance();

	public static void main(String[] args) {

		 new Controller().begin();
	}
	private void begin (){
		Scanner s =new Scanner(System.in);
		
		int menu;
		
		do{	
			System.out.println("로그인 \t 회원가입");
			System.out.println("-----------메뉴-----------");
			System.out.println("XX 호텔\t ★★★★★");
			System.out.println("TT 호텔\t ★★★");
			System.out.println("DD 호텔\t ★★");
			System.out.println("OO 호텔\t ★★★★★");
			System.out.println("-------------------------");
			System.out.print("1. 로그인");
			System.out.print("\t 2. 회원가입");
			System.out.println("\t 0. 프로그램 종료");
			System.out.println("-------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
			menu =Integer.parseInt(s.nextLine());
			
			switch (menu) {
			case 1: //로그인
				
				break;
			case 2: //회원가입
				
				break;
			case 3: //회원 리스트
				
				break;
			case 0: //프로그램 종료
				
				break;
			}
			
			// 로그아웃 페이지 
		}while(menu != 0);
		
	}

}

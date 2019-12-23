package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import vo.UserVO;


public class ReservationService implements Reservation{
	int startDay;
	int endDt;
	int reservationId;
	String startDt ="";
	
			
	public static int getDateByInteger(Date date) {
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	     return Integer.parseInt(sdf.format(date));
	 }
	
	 Date today =new Date();
//		for(int i =0; i<p)
		ArrayList<ArrayList<Integer>> checkIndays = new ArrayList<>();				//회원수만큼 예약담기[[예약아이디1, 예약날짜,예약날짜,..],
//																								   [예약아이디2, 예약날짜,예약날짜,..]]
	/*
	 * 	ArrayList를 이용한 2차배열 이용
	 * 
	 */
		@Override
		public void roomCheckIn() {
	//-------------------------------체크인 입력부---------------------------------------//	
			Scanner s = new Scanner(System.in);
			System.out.println("체크인 날짜를\t(ex 20200701) 입력주세요>");
			startDt =s.nextLine();									//String 타입
			
			System.out.println("체크아웃 날짜를\t(ex 20200701) 입력주세요>");
			endDt =Integer.parseInt(s.nextLine());					//int 타입
	      
	//-------------------------------체크인 날짜 계산---------------------------------------//
	     int startYear = Integer.parseInt(startDt.substring(0,4));
	     int startMonth= Integer.parseInt(startDt.substring(4,6));
	     int startDate = Integer.parseInt(startDt.substring(6,8));

	     Calendar cal = Calendar.getInstance();
	      
	     // Calendar의 Month는 0부터 시작하므로 -1 해준다.
	     // Calendar의 기본 날짜를 startDt로 셋팅해준다.
	     
	     cal.set(startYear, startMonth -1, startDate);
	     
	     ArrayList<Integer> list1 = new ArrayList<>();								//2번째 배열
	  /*----------------------------------------------------------------------/
	   *  예약 아이디를 list1의 배열 첫번째에 넣기 										 *
	   *----------------------------------------------------------------------*/
	     
	//--------------------------------날짜 출력-------------------------------------------//    
	     while(true) {
	         System.out.println(getDateByInteger(cal.getTime()));					// 날짜 출력
	         
	         cal.add(Calendar.DATE, 1); 											// Calendar의 날짜를 하루씩 증가한다.
	         list1.add(getDateByInteger(cal.getTime()));
	         if(getDateByInteger(cal.getTime()) >= endDt) 							// 현재 날짜가 종료일자보다 크거나 같을때
	        	break;
	     }
	     checkIndays.add(list1);
	     	     
}
  
	


	@Override
	public void selectReservation() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void cancelReservation() {
		// TODO Auto-generated method stub
		
	}

}

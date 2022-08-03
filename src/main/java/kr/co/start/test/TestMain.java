package kr.co.start.test;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.start.members.BankMembersDao;
import kr.co.start.members.BankMembersDto;

public class TestMain {

	public static void main(String[] args) {
		
		BankMembersDto testData = new BankMembersDto();
		testData.setUserName("n2");
		testData.setPassword("p2");
		testData.setName("테스트2");
		testData.setEmail("e2@email.com");
		testData.setPhone("010-2222-3333");
		
		BankMembersDao bankMembersDao = new BankMembersDao();
		Scanner sc = new Scanner(System.in);
		
		try {
			/*int result = bankMembersDao.setJoin(testData);
			
			if(result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}*/
			
			System.out.print("검색어 입력 : ");
			String search = sc.next();
			
			ArrayList<BankMembersDto> results = bankMembersDao.getSearchById(search);
			
			for(BankMembersDto result : results) {
				System.out.println(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

}

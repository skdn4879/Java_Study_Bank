package kr.co.start.test;

import kr.co.start.bankbook.BankBookDao;
import kr.co.start.bankbook.BankBookDto;

public class BankBookTestMain {

	public static void main(String[] args) {
		
		BankBookDao bankBookDao = new BankBookDao();
		
		/*BankBookDto testData = new BankBookDto();
		testData.setBookNum(1659508894151L);
		testData.setBookSale(0);*/
		//testData.setBookName("씨앗입출금통장(구)");
		//testData.setBookRate(5.02);
		
		BankBookDto detailTestDate = new BankBookDto(10L, "실험용", 0.1, 1);
		
		try {
			/*int result = bankBookDao.setBankBook(testData);
			
			if(result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}*/
			
			/*for(BankBookDto result : bankBookDao.getList()) {
				System.out.println(result);
			}*/
			
			BankBookDto result = bankBookDao.getDetail(detailTestDate);
			System.out.println(result);
			
			/*int result = bankBookDao.setChangeSale(testData);
			
			if(result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

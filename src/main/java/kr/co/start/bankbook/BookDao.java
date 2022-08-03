package kr.co.start.bankbook;

import java.util.ArrayList;

public interface BookDao {

	//bankBook 테이블에 insert (booksale은 기본 1, booknum은 현재 시간을 밀리초로 변환 후 집어넣기)
	public int setBankBook(BankBookDto bankBookDto) throws Exception;
	
	//BankBook 모든 데이터를 조회, 최신순으로(DESC)
	public ArrayList<BankBookDto> getList() throws Exception;
	
	//bookSale 컬럼 값 수정
	public int setChangeSale(BankBookDto bankBookDto) throws Exception;
	
	//BookNum의 값으로 조회
	public BankBookDto getDetail(BankBookDto bankBookDto) throws Exception;
	
}

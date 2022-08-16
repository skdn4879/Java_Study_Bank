package kr.co.start.members;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDao bankMembersDao;
	
	//bankMembers 테이블 회원가입
	public int setJoin(BankMembersDto bankMembersDto) throws Exception {
		return bankMembersDao.setJoin(bankMembersDto);
	}
		
	//검색어를 입력해 아이디(username)를 찾기(검색어를 포함된 애들) abc순으로 정렬
	public ArrayList<BankMembersDto> getSearchById(String search) throws Exception {
		return bankMembersDao.getSearchById(search);
	}
		
	public BankMembersDto login(BankMembersDto bankMembersDto) throws Exception {
		return bankMembersDao.login(bankMembersDto);
	}
	
}

package kr.co.start.members;

import java.util.List;

public interface MembersDao {
	
	//bankMembers 테이블 회원가입
	public int setJoin(BankMembersDto bankMembersDto) throws Exception;
	
	//검색어를 입력해 아이디(username)를 찾기(검색어를 포함된 애들) abc순으로 정렬
	public List<BankMembersDto> getSearchById(String search) throws Exception;
	
	public BankMembersDto login(BankMembersDto bankMembersDto) throws Exception;

}

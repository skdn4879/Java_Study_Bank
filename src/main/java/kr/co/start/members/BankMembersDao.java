package kr.co.start.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.start.util.DBConnector;

@Repository
public class BankMembersDao implements MembersDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.start.members.BankmembersDao.";
	
	@Override
	public List<BankMembersDto> getSearchById(String search) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getSearchById", search);
		
	}

	@Override
	public int setJoin(BankMembersDto bankMembersDto) throws Exception {
		return sqlSession.insert(NAMESPACE + "setJoin", bankMembersDto);
	}
	
	@Override
	public BankMembersDto login(BankMembersDto bankMembersDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "login", bankMembersDto);
		
	}
	
}

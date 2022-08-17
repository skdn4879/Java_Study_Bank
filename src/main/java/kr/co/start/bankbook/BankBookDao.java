package kr.co.start.bankbook;

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
public class BankBookDao implements BookDao {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.start.bankbook.BankBookDao.";
	
	@Override
	public int setBankBook(BankBookDto bankBookDto) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setBankBook", bankBookDto);
		
	}

	@Override
	public List<BankBookDto> getList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList");
		
	}

	@Override
	public int setChangeSale(BankBookDto bankBookDto) throws Exception {
		
		return sqlSession.update(NAMESPACE + "setChangeSale", bankBookDto);
		
	}

	@Override
	public BankBookDto getDetail(BankBookDto bankBookDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", bankBookDto);
		
	}
	
}

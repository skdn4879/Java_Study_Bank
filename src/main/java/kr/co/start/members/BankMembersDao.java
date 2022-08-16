package kr.co.start.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.start.util.DBConnector;

@Repository
public class BankMembersDao implements MembersDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.start.members.BankMembersDao."; 
	
	@Override
	public ArrayList<BankMembersDto> getSearchById(String search) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. query 작성
		String sql = "SELECT * FROM bankmembers WHERE username LIKE '%' || ? || '%' ORDER BY username ASC";
		
		//3. query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅
		st.setString(1, search);
		
		ArrayList<BankMembersDto> results = new ArrayList<BankMembersDto>();
		
		//5. 최종전송 후 결과처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDto result = new BankMembersDto(rs.getString("username"), rs.getString("password"),
					rs.getString("name"), rs.getString("email"), rs.getString("phone"));
			
			results.add(result);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return results;
	}

	@Override
	public int setJoin(BankMembersDto bankMembersDto) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. query 작성
		String sql = "INSERT INTO bankmembers(username, password, name, email, phone) VALUES(?, ?, ?, ?, ?)";
		
		//3. query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅
		st.setString(1, bankMembersDto.getUserName());
		st.setString(2, bankMembersDto.getPassword());
		st.setString(3, bankMembersDto.getName());
		st.setString(4, bankMembersDto.getEmail());
		st.setString(5, bankMembersDto.getPhone());
		
		//5. 최종전송 후 결과처리
		int result = st.executeUpdate();
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	@Override
	public BankMembersDto login(BankMembersDto bankMembersDto) throws Exception {
		
		/* 아래의 코드를 이제 mybatis로 사용한다.
		 * Connection con = DBConnector.getConnection(); String sql =
		 * "SELECT * FROM bankmembers WHERE username = ? AND password = ?";
		 * PreparedStatement st = con.prepareStatement(sql); st.setString(1,
		 * bankMembersDto.getUserName()); st.setString(2, bankMembersDto.getPassword());
		 * ResultSet rs = st.executeQuery(); BankMembersDto result = null;
		 * 
		 * if(rs.next()) { result = new BankMembersDto(rs.getString("username"),
		 * rs.getString("name"), rs.getString("email"), rs.getString("phone")); }
		 * 
		 * DBConnector.disConnect(rs, st, con);
		 */
		
		return sqlSession.selectOne(NAMESPACE + "login", bankMembersDto);
		// "kr.co.start.members.BankMembersDao.login"
	}
	
}

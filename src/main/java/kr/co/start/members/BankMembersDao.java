package kr.co.start.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.start.util.DBConnector;

public class BankMembersDao implements MembersDao {
	
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
	
}

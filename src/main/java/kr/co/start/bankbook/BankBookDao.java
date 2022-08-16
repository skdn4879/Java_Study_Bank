package kr.co.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import kr.co.start.util.DBConnector;

@Repository
public class BankBookDao implements BookDao {

	@Override
	public int setBankBook(BankBookDto bankBookDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO bankbook VALUES(?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDto.getBookNum());
		st.setString(2, bankBookDto.getBookName());
		st.setDouble(3, bankBookDto.getBookRate());
		st.setInt(4, bankBookDto.getBookSale());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public ArrayList<BankBookDto> getList() throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM bankbook ORDER BY booknum DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<BankBookDto> results = new ArrayList<BankBookDto>();
		
		while(rs.next()) {
			results.add(new BankBookDto(rs.getLong("booknum"), rs.getString("bookname"), 
					rs.getDouble("bookrate"), rs.getInt("booksale")));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return results;
	}

	@Override
	public int setChangeSale(BankBookDto bankBookDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE bankbook SET booksale = ? WHERE booknum = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, bankBookDto.getBookSale());
		st.setLong(2, bankBookDto.getBookNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public BankBookDto getDetail(BankBookDto bankBookDto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM bankbook WHERE booknum = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDto.getBookNum());
		
		ResultSet rs = st.executeQuery();
		
		BankBookDto result = null;
		
		if(rs.next()) {
			result = new BankBookDto(rs.getLong("booknum"), rs.getString("bookname"),
					rs.getDouble("bookrate"), rs.getInt("booksale"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}
	
}

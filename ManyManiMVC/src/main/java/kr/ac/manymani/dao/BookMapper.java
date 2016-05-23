package kr.ac.manymani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.manymani.domain.Book;

public class BookMapper implements RowMapper<Book> {

	

	@Override
	public Book mapRow(ResultSet rs, int reoNum) throws SQLException {

		Book book = new Book();
		
		book.setBookName(rs.getString("bookName"));
		book.setBookNumber(rs.getString("bookNumber"));
		book.setBorrowAvailability(rs.getString("borrowAvailability"));
		book.setBorrowerId(rs.getString("borrowerId"));
		book.setIndex(rs.getInt("index"));
		book.setBorrowDate(rs.getString("borrowDate"));
		book.setReturnDate(rs.getString("returnDate"));
		
		return book;
	}
	
}


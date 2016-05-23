package kr.ac.manymani.dao;

import java.util.List;

import javax.sql.DataSource;
import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("bookDAO")
public class BookDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from book";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// ï¿½ë¸¯ï¿½êµ¹ï¿½ì“½
																				// ï¿½ì‚¤?‡‰?š¯? ¥ï¿½ë“ƒ

	}

	// Querying and returning a single object
	public Book getBook(String bookNumber) {

		String sqlStatement = "select * from book where bookNumber=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { bookNumber }, new BookMapper());

	}

	// Querying and returning multiple object
	public List<Book> getBooks() {

		String sqlStatement = "select * from book";

		return jdbcTemplateObject.query(sqlStatement, new BookMapper()); // Anonymous
																			// Classes

	}

	/*
	 * public boolean insert(Book book){
	 * 
	 * String memberId = member.getMemberId(); String password =
	 * member.getPassword(); String bookName = member.getBookName(); String
	 * lendingTerm = member.getLendingTerm(); int point = member.getPoint();
	 * String email = member.getEmail();
	 * 
	 * 
	 * String sqlStatement=
	 * "insert into member (memberId, password, bookName, lendingTerm, point, email) values (?,?,?,?,?,?)"
	 * ; return (jdbcTemplateObject.update(sqlStatement, new Object[]{memberId,
	 * password, bookName, lendingTerm, point, email})==1); }
	 * 
	 */

	
	
	public boolean update(Book book) {

		String borrowAvailability = book.getBorrowAvailability();
		String borrowerId = book.getBorrowerId();
		String bookName = book.getBookName();
		String borrowDate = book.getBorrowDate();
		String returnDate = book.getReturnDate();

		String sqlStatement = "update book set borrowAvailability=?, borrowerId=?, borrowDate = ?, returnDate = ? where bookName=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { borrowAvailability, borrowerId, borrowDate, returnDate, bookName}) == 1);
	}

	
	
	
	

	/*
	 * public boolean delete (int id) {
	 * 
	 * String sqlstatement="delete from member where id=?";
	 * return(jdbcTemplateObject.update(sqlstatement,new Object[]{id})==1); }
	 * 
	 * 
	 */

}

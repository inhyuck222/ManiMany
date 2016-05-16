package kr.ac.manymani.dao;

import java.util.List;

import javax.sql.DataSource;
import kr.ac.manymani.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component�뒗 �씠 �겢�옒�뒪?���? �옄�룞�쑝濡� ?��?��?��濡� �꽕�젙�빐 以��떎.
@Component("bookDAO")
public class BookDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired 寃쎌?�� type�씠 媛숈�? 寃쎌?��?���? 泥섎?���븳�떎.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from book";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// �븯�굹�쓽
																				// �삤?��?��?���듃

	}

	// Querying and returning a single object
	public Book selectBookInfo(String bookNumber) {

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
	public boolean insert(Book book){
		
		 String memberId = member.getMemberId();
		 String password = member.getPassword();
		 String bookName = member.getBookName();
		 String lendingTerm = member.getLendingTerm();
		 int point = member.getPoint();
		 String email = member.getEmail();
		
				
		String sqlStatement="insert into member (memberId, password, bookName, lendingTerm, point, email) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{memberId, password, bookName, lendingTerm, point, email})==1);
	}

	*/
	public boolean update(Book book){
		
		 String bookNumber = book.getBookNumber(); 
		 String bookName = book.getBookName();
		 String borrowAvailability = book.getBorrowAvailability();
		 String lendingTerm = book.getLendingTerm();
		 String borrowerId = book.getBorrowerId();
		
		String sqlStatement="update member set bookNumber=?, bookName=?, borrowAvailability=?, lendingTerm=?, borrowerId=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{bookNumber, bookName, borrowAvailability, lendingTerm, borrowerId})==1);
	}

	
	/*	
	public boolean delete (int id) {
		
		String sqlstatement="delete from member where id=?";
		return(jdbcTemplateObject.update(sqlstatement,new Object[]{id})==1);
	}
	
	
*/
	
}

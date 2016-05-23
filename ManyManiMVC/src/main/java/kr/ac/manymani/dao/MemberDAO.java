package kr.ac.manymani.dao;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.manymani.domain.Member;

//@Component�뒗 �씠 �겢�옒�뒪?���? �옄�룞�쑝濡� ?��?��?��濡� �꽕�젙�빐 以��떎.
@Component("memberDAO")
public class MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired 寃쎌?�� type�씠 媛숈�? 寃쎌?��?���? 泥섎?���븳�떎.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from member";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// �븯�굹�쓽
																				// �삤?��?��?���듃

	}

	// Querying and returning a single object
	public Member getMember(String name) {
		try {
			String sqlStatement = "select * from member where memberId=?";

			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new MemberMapper());
		} catch (Exception e) {

			System.out.println("DAO ���� ó�� �߻� ȹ�� �޼��� ");
			e.printStackTrace();
			return null;

		}

	}

	// Querying and returning multiple object
	public List<Member> getMembers() {

		String sqlStatement = "select * from member";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper()); // Anonymous
																			// Classes

	}

	public boolean insert(Member member) {

		String memberId = member.getMemberId();
		String password = member.getPassword();
		String bookName = member.getBookName();
		String borrowDate = member.getBorrowDate();
		String returnDate = member.getReturnDate();
		int point = member.getPoint();
		String email = member.getEmail();

		String sqlStatement = "insert into member (memberId, password, bookName, borrowDate, returnDate,point, email) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { memberId, password, bookName, borrowDate, returnDate, point, email }) == 1);
	}

	public boolean update(Member member) {

		String memberId = member.getMemberId();
		String bookName = member.getBookName();
		int point = member.getPoint();
		String borrowDate = member.getBorrowDate();
		String returnDate = member.getReturnDate();
	
		
		String sqlStatement = "update member set bookName=?, point=?, borrowDate = ?, returnDate = ? where memberId=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { bookName, point, borrowDate, returnDate,memberId }) == 1);
	}

	public boolean delete(int id) {

		String sqlstatement = "delete from member where id=?";
		return (jdbcTemplateObject.update(sqlstatement, new Object[] { id }) == 1);
	}
	
	
	
	

}

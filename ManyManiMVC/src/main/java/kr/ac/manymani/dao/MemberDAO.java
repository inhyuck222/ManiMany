package kr.ac.manymani.dao;

import java.util.List;

import javax.sql.DataSource;
import kr.ac.manymani.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Componentï¿½ë’— ï¿½ì”  ï¿½ê²¢ï¿½ì˜’ï¿½ë’ª?‘œï¿? ï¿½ì˜„ï¿½ë£ï¿½ì‘æ¿¡ï¿½ ?®?‰?‘æ¿¡ï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¹ ä»¥ï¿½ï¿½ë–.
@Component("memberDAO")
public class MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired å¯ƒìŒ?Š¦ typeï¿½ì”  åª›ìˆˆï¿? å¯ƒìŒ?Š¦?‘œï¿? ï§£ì„?”ï¿½ë¸³ï¿½ë–.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from member";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);// ï¿½ë¸¯ï¿½êµ¹ï¿½ì“½
																				// ï¿½ì‚¤?‡‰?š¯? ¥ï¿½ë“ƒ

	}

	// Querying and returning a single object
	public Member getMember(String name) {

		String sqlStatement = "select * from member where memberId=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new MemberMapper());

	}

	// Querying and returning multiple object
	public List<Member> getMembers() {

		String sqlStatement = "select * from member";

		return jdbcTemplateObject.query(sqlStatement, new MemberMapper()); // Anonymous
																			// Classes

	}
	

	public boolean insert(Member member){
		
		 String memberId = member.getMemberId();
		 String password = member.getPassword();
		 String bookName = member.getBookName();
		 String lendingTerm = member.getLendingTerm();
		 int point = member.getPoint();
		 String email = member.getEmail();
		
				
		String sqlStatement="insert into member (memberId, password, bookName, lendingTerm, point, email) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{memberId, password, bookName, lendingTerm, point, email})==1);
	}

	
	public boolean update(Member member){
		
		 String memberId = member.getMemberId();
		 String password = member.getPassword();
		 String bookName = member.getBookName();
		 String lendingTerm = member.getLendingTerm();
		 int point = member.getPoint();
		 String email = member.getEmail();
		
		String sqlStatement="update member set memberId=?, password=?, bookName=?, lendingTerm=?, point=?, email=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{memberId, password, bookName, lendingTerm, point, email})==1);
	}
	
	public boolean delete (int id) {
		
		String sqlstatement="delete from member where id=?";
		return(jdbcTemplateObject.update(sqlstatement,new Object[]{id})==1);
	}
	
	

	
}

package kr.ac.manymani.dao;




import java.sql.ResultSet;
import java.sql.SQLException;
import kr.ac.manymani.domain.Member;
import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {

	
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member member =new Member();
		
		member.setMemberId(rs.getString("memberId"));
		member.setPassword(rs.getString("password"));
		member.setBookName(rs.getString("bookName"));
		member.setLendingTerm(rs.getString("lendingTerm"));
		member.setPoint(rs.getInt("point"));
		member.setEmail(rs.getString("email"));

		return member;
		
		
		
	}
	
	
	
	
}

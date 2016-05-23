package kr.ac.manymani.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.manymani.dao.BookDAO;
import kr.ac.manymani.dao.MemberDAO;
import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;

@Service("returnService")
public class ReturnService {
	private BookDAO bookDAO;
	private MemberDAO memberDAO;
	private PointRuleService pointRuleService;
	@Autowired
	public void setBookDAO(BookDAO bookDAO,PointRuleService pointRuleService) {
		this.bookDAO = bookDAO;
		this.pointRuleService=pointRuleService;
	}

	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {

		this.memberDAO = memberDAO;
	}

	public int checkLate(String returnDate) {

		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    
	    String today = df.format(cal.getTime());
	    
		try {
			DateFormat dif = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = dif.parse(today);
			Date endDate = dif.parse(returnDate);

			long diff = endDate.getTime() - beginDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			int result = (int) diffDays;

			return result;

		} catch (ParseException e) {
			e.printStackTrace();
			return -999;

		}
	    
	 
	  
	   
	    //String returnTime = df.format(cal.getTime());
	
	    // Æ¯Á¤ ÇüÅÂÀÇ ³¯Â¥·Î °ªÀ» »Ì±â 
	   
	}

	public String returnBook(String bookNumber) {

		Book book=bookDAO.getBook(bookNumber);
		Member member= memberDAO.getMember(book.getBorrowerId());
		int resultDate=checkLate(book.getReturnDate());
		
		if (resultDate == -999) return "¹Ý³³½ÇÆÐ";
		pointRuleService.caclulateReturnPoint(book, member, resultDate);
		
		book.setBorrowDate(null);
		book.setReturnDate(null);
		book.setBorrowerId(null);
		book.setBorrowAvailability(null);
		
		member.setBorrowDate(null);
		member.setReturnDate(null);
		member.setBookName(null);
				
		bookDAO.update(book);
		memberDAO.update(member);
		
		return "¹Ý³³µÊ";
	}

}

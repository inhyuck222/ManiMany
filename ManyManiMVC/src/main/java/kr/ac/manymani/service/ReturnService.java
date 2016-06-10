package kr.ac.manymani.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
	private MailService mailService;
	private SimpleMailMessage message;
	
	@Autowired
	public void setBookDAO(BookDAO bookDAO,PointRuleService pointRuleService,MailService mailService, SimpleMailMessage message) {
		this.bookDAO = bookDAO;
		this.pointRuleService=pointRuleService;
		this.mailService=mailService;
		this.message = message;
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
	
	    // Ư�� ������ ��¥�� ���� �̱� 
	   
	}

	public String returnBook(String bookNumber) {

		Book book=bookDAO.getBook(bookNumber);
		if(book==null) return "�ݳ�����";
		if(book.getBorrowAvailability().equals("�뿩����"))return "�ݳ�����";
		
		Member member= memberDAO.getMember(book.getBorrowerId());
		int resultDate=checkLate(book.getReturnDate());
		
		if (resultDate == -999) return "�ݳ�����";
		pointRuleService.caclulateReturnPoint(book, member, resultDate);
		
		message.setFrom("nihil0821@gmail.com");
		message.setTo(member.getEmail());
		message.setSubject("ManiMany ���� �ݳ� �˶�");
		message.setText("���� ����Ʈ:" + member.getPoint() + "\n" + member.getBookName() + ": �ݳ��� ���������� �Ǿ����ϴ�.");
	
		book.setBorrowDate("1111-11-11");
		book.setReturnDate("1111-11-11");
		book.setBorrowerId("null");
		book.setBorrowAvailability("�뿩����");
		
		member.setBorrowDate("1111-11-11");
		member.setReturnDate("1111-11-11");
		member.setBookName("null");
				
		bookDAO.update(book);
		memberDAO.update(member);
		
		

		mailService.sendMail(message);
		
		return "�ݳ���";
	}

}

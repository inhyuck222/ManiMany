package kr.ac.manymani.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import kr.ac.manymani.dao.BookDAO;
import kr.ac.manymani.dao.MemberDAO;
import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;

@Service("borrowService") //service로 bean에 등록시켜준다
public class BorrowService {

	private BookDAO bookDAO;
	private PointRuleService pointRuleService;
	private MemberDAO memberDAO;
	private MailService mailService;
	private SimpleMailMessage message;
	
 	@Autowired //DI 주입
	public void setBookDAO(BookDAO bookDAO,PointRuleService pointRuleService,MemberDAO memberDAO ,MailService mailService, SimpleMailMessage message){	
		this.bookDAO = bookDAO;
		this.pointRuleService=pointRuleService;
		this.memberDAO = memberDAO;
		this.mailService= mailService;
		this.message = message;
	}
	 
	
	public Book checkBorrow(String bookNumber){	
		
		String borrowAvailability="대여중";
		
		Book book= bookDAO.getBook(bookNumber);
		if(book==null) return null;
		
		if(borrowAvailability.equals(book.getBorrowAvailability())){
			
			System.out.println("현재"+book.getBookName()+"은 대여 중입니다.");
			
		}else{
			
			System.out.println("현재"+book.getBookName()+"은 대여 할 수 있습니다.");
			
		}
		
		return book;
	}


	public String usePoint(String usepoint, Member member, Book book){
		
		
		int CurrentPoint=member.getPoint();
		String resultLendTerm=pointRuleService.caclulateBorrowPoint(member, usepoint, CurrentPoint);
		String memberId, bookName;
		
		int resultLendingintTerm = Integer.parseInt(resultLendTerm);
		
		if(resultLendingintTerm<0){
			return "대여싱패";
		}
		    
			Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    
		    String borrowtime = df.format(cal.getTime());
		    member.setBorrowDate(borrowtime);
		    book.setBorrowDate(borrowtime);
		    
		    cal.add(Calendar.DATE,resultLendingintTerm);
		   
		    String returnTime = df.format(cal.getTime());
		    member.setReturnDate(returnTime);
		    book.setReturnDate(returnTime);
		    // 특정 형태의 날짜로 값을 뽑기 
		   
	    
		//멤버 id set
		memberId = member.getMemberId();
		book.setBorrowerId(memberId);
		
		//bookName을 member에 set
		bookName = book.getBookName();
		member.setBookName(bookName);
		
		//대여 가능 여부 set
		book.setBorrowAvailability("대여중");
		
		
		//DAO에 최신 정보 update 요청 실시간 date계산은 넘기는걸로 수정
		bookDAO.update(book);
		memberDAO.update(member);

		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");*/

		message.setFrom("nihil0821@gmail.com");
		message.setTo(member.getEmail());
		message.setSubject("ManiMany 도서 대여 알람");
		message.setText("현재 포인트:" + member.getPoint() + "\n" + member.getBookName() + ": 대여가 성공적으로 되었습니다.");

		mailService.sendMail(message);
		
		return "대여성공";
	}
	
	
	
	
	
}

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

@Service("borrowService") //service�� bean�� ��Ͻ����ش�
public class BorrowService {

	private BookDAO bookDAO;
	private PointRuleService pointRuleService;
	private MemberDAO memberDAO;
	private MailService mailService;
	private SimpleMailMessage message;
	
 	@Autowired //DI ����
	public void setBookDAO(BookDAO bookDAO,PointRuleService pointRuleService,MemberDAO memberDAO ,MailService mailService, SimpleMailMessage message){	
		this.bookDAO = bookDAO;
		this.pointRuleService=pointRuleService;
		this.memberDAO = memberDAO;
		this.mailService= mailService;
		this.message = message;
	}
	 
	
	public Book checkBorrow(String bookNumber){	
		
		String borrowAvailability="�뿩��";
		
		Book book= bookDAO.getBook(bookNumber);
		if(book==null) return null;
		
		if(borrowAvailability.equals(book.getBorrowAvailability())){
			
			System.out.println("����"+book.getBookName()+"�� �뿩 ���Դϴ�.");
			
		}else{
			
			System.out.println("����"+book.getBookName()+"�� �뿩 �� �� �ֽ��ϴ�.");
			
		}
		
		return book;
	}


	public String usePoint(String usepoint, Member member, Book book){
		
		
		int CurrentPoint=member.getPoint();
		String resultLendTerm=pointRuleService.caclulateBorrowPoint(member, usepoint, CurrentPoint);
		String memberId, bookName;
		
		int resultLendingintTerm = Integer.parseInt(resultLendTerm);
		
		if(resultLendingintTerm<0){
			return "�뿩����";
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
		    // Ư�� ������ ��¥�� ���� �̱� 
		   
	    
		//��� id set
		memberId = member.getMemberId();
		book.setBorrowerId(memberId);
		
		//bookName�� member�� set
		bookName = book.getBookName();
		member.setBookName(bookName);
		
		//�뿩 ���� ���� set
		book.setBorrowAvailability("�뿩��");
		
		
		//DAO�� �ֽ� ���� update ��û �ǽð� date����� �ѱ�°ɷ� ����
		bookDAO.update(book);
		memberDAO.update(member);

		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");*/

		message.setFrom("nihil0821@gmail.com");
		message.setTo(member.getEmail());
		message.setSubject("ManiMany ���� �뿩 �˶�");
		message.setText("���� ����Ʈ:" + member.getPoint() + "\n" + member.getBookName() + ": �뿩�� ���������� �Ǿ����ϴ�.");

		mailService.sendMail(message);
		
		return "�뿩����";
	}
	
	
	
	
	
}

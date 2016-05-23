package kr.ac.manymani.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;
import kr.ac.manymani.dao.BookDAO;
import kr.ac.manymani.dao.MemberDAO;

@Service("borrowService") //service�� bean�� ��Ͻ����ش�
public class BorrowService {

	private BookDAO bookDAO;
	private PointRuleService pointRuleService;
	private MemberDAO memberDAO;
	
	
 	@Autowired //DI ����
	public void setBookDAO(BookDAO bookDAO,PointRuleService pointRuleService,MemberDAO memberDAO){	
		this.bookDAO = bookDAO;
		this.pointRuleService=pointRuleService;
		this.memberDAO = memberDAO;
	}
	 
	
	public Book checkBorrow(String bookNumber){	
		
		String borrowAvailability="�뿩��";
		
		Book book= bookDAO.getBook(bookNumber);
		
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
		
		
		
		return "�뿩����";
	}
	
	
	
	
	
}

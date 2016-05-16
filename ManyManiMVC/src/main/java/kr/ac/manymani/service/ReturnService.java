package kr.ac.manymani.service;

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
	
	@Autowired
	public void setBookDAO(BookDAO bookDAO){
		this.bookDAO = bookDAO;
	}
	
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	public Book returnBook(String bookNumber){
		Book book = bookDAO.selectBookInfo(bookNumber);
		String borrowerTerm = book.getLendingTerm();
		String borrowerId = book.getBorrowerId();
		
		Member member = memberDAO.getMember(borrowerId);
		
		//���ǿ��� ��� �޾ƿͼ� �ϸ� ��
		
		
		
		return book;
	}
	
	public String checkLate(String borrowerTerm){
		
		return "�ݳ���";
	}
}

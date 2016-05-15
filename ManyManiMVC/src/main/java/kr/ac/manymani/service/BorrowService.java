package kr.ac.manymani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.dao.BookDAO;

@Service("borrowService") //service�� bean�� ��Ͻ����ش�
public class BorrowService {

	private BookDAO bookDAO;
	
	@Autowired //DI ����
	public void setBookDAO(BookDAO bookDAO){	
		this.bookDAO = bookDAO;
	}
	
	public Book checkBorrow(String bookNumber){	
		
		String borrowAvailability="using";
		Book book= bookDAO.selectBookInfo(bookNumber);
		
		if(borrowAvailability.equals(book.getBorrowAvailability())){
			
			System.out.println("����"+book.getBookName()+"�� �뿩 ���Դϴ�.");
			
		}else{
			
			System.out.println("����"+book.getBookName()+"�� �뿩 �� �� �ֽ��ϴ�.");
			
		}
		
		return book;
	}




}

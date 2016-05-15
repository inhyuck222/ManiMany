package kr.ac.manymani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.dao.BookDAO;

@Service("borrowService") //service로 bean에 등록시켜준다
public class BorrowService {

	private BookDAO bookDAO;
	
	@Autowired //DI 주입
	public void setBookDAO(BookDAO bookDAO){	
		this.bookDAO = bookDAO;
	}
	
	public Book checkBorrow(String bookNumber){	
		
		String borrowAvailability="using";
		Book book= bookDAO.selectBookInfo(bookNumber);
		
		if(borrowAvailability.equals(book.getBorrowAvailability())){
			
			System.out.println("현재"+book.getBookName()+"은 대여 중입니다.");
			
		}else{
			
			System.out.println("현재"+book.getBookName()+"은 대여 할 수 있습니다.");
			
		}
		
		return book;
	}




}

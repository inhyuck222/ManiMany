package kr.ac.manymani.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.service.BorrowService;

@Controller // 자바클래스를 bean으로 등록시킨다.
public class BorrowBookController {

	private BorrowService borrowService;

	@Autowired // di 주입
	public void setLoginService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	@RequestMapping("/borrowBook")
	public String showBorrowBookPage() {

		return "borrowBook";
	}

	@RequestMapping("/DoBorrowBook")
	public String DoBorrowBookPage(HttpServletRequest request, HttpServletResponse response, Model model) {

		String bookNumber = request.getParameter("bookNumber");

		Book book = borrowService.checkBorrow(bookNumber);
		if (book.getBorrowAvailability().equals("void") ) {
			//책을 빌릴 수 있는 상태입 
			
			model.addAttribute("ironman1", book.getBorrowAvailability());
			System.out.println("모델 아이언1");
			return "DoBorrowBook";

		} else {
			//책을 빌릴수 없는 상태임 
			
			model.addAttribute("ironman2", book.getBorrowAvailability());
			System.out.println("모델 아이언2");
			return "failBorrowBook";
		}

	}
	
	@RequestMapping("/failBorrowBook")
	public String showfailBorrowBookPage() {

		return "failBorrowBook";
	}

}

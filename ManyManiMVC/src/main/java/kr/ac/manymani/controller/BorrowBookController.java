package kr.ac.manymani.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.service.BorrowService;

@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class BorrowBookController {

	private BorrowService borrowService;

	@Autowired // di ����
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
			model.addAttribute("ironman1", book.getBorrowAvailability());
			System.out.println("�� ���̾�1");
			return "DoBorrowBook";

		} else {
			model.addAttribute("ironman2", book.getBorrowAvailability());
			System.out.println("�� ���̾�2");
			return "borrowBook";
		}

	}

}

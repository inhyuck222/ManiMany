package kr.ac.manymani.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;
import kr.ac.manymani.service.BorrowService;

@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class BorrowBookController {

	private BorrowService borrowService;
	//private PointRuleService pointRuleService;

	@Autowired // di ����
	public void setLoginService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	@RequestMapping("/borrowBook")
	public String showBorrowBookPage(HttpSession session) {
		
		String rcv = (String) session.getAttribute("logOk");
		System.out.println(rcv);
		if (rcv != null){
			
			return "borrowBook";
			
		}else{
			
			return "guideLogin";
			
		
		}
	}

	@RequestMapping("/DoBorrowBook")
	public String DoBorrowBookPage(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) {

		
		
		
		String bookNumber = request.getParameter("bookNumber");
		
		//memberInfo�� session���� memberDomain�� �޾ƿԴ�.
		Member member = (Member)session.getAttribute("memberInfo");
		
		Book book = borrowService.checkBorrow(bookNumber);
		if (book.getBorrowAvailability().equals("void") ) {
			//å�� ���� �� �ִ� ������ 
			
			model.addAttribute("ironman1", book.getBorrowAvailability());
			System.out.println("�� ���̾�1");
			return "DoBorrowBook";

		} else {
			//å�� ������ ���� ������ 
			
			model.addAttribute("ironman2", book.getBorrowAvailability());
			System.out.println("�� ���̾�2");
			return "failBorrowBook";
		}

		
	}
	
	
	@RequestMapping("/failBorrowBook")
	public String showfailBorrowBookPage() {

		return "failBorrowBook";
	}

	
	
	
	/*controller���� session���� �޾ƿ� ����� �Ű������� �Ѱ������
	@RequestMapping("/DoUsePoint")
	public String DoUsePoint(HttpServletRequest request, HttpServletResponse response, Model model) {
		String pointStr = request.getParameter("point");
		int point = Integer.parseInt(pointStr);
		int calculatedPoint = pointRuleService.caclulateBorrowPoint(point);
		

		return "failBorrowBook";
	}*/
}

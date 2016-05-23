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
import kr.ac.manymani.service.PointRuleService;

@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class BorrowBookController {

	private BorrowService borrowService;
	private PointRuleService pointRuleService;
	//private PointRuleService pointRuleService;

	@Autowired // di ����
	public void setLoginService(BorrowService borrowService,PointRuleService pointRuleService ) {
		this.pointRuleService = pointRuleService;
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

		
		
		//borrowBook���������� �Է��� å��ȣ�� �޾ƿ´�.
		String bookNumber = request.getParameter("bookNumber");
		
		//memberInfo�� session���� memberDomain�� �޾ƿԴ�.
		Member loginStudent = (Member)session.getAttribute("loginStudent");
		
		Book book = borrowService.checkBorrow(bookNumber);
		
		
		if (book.getBorrowAvailability().equals("null") ) {
			//å�� ���� �� �ִ� ������ 
			System.out.println("å�� ���� �� �ִ� controller"+book);
			model.addAttribute("TryBookModel", book);
			session.setAttribute("TryBookSession", book);
			return "DoBorrowBook";

		} else {
			//å�� ������ ���� ������ 
			
			System.out.println("å�� ���� ����  controller"+book);
			return "failBorrowBook";
		}

		
	}
	
	
	
	
	@RequestMapping("/DoUsePoint")
	public String showDoUsePointPage(HttpServletRequest request,Model model,HttpSession session) {
		
		String usePoint = request.getParameter("point");
		Book book =(Book)session.getAttribute("TryBookSession");
		Member member =(Member)session.getAttribute("loginStudent");		
		
		System.out.println("å�� ���� �� �ִ� DoUsePoint"+book+usePoint+member);
		
		String rcv =borrowService.usePoint(usePoint,member,book);
		if(rcv.equals("�뿩����")){
			
			return "failUsePoint";
			
		}else{
	
		return "home";
	
		}
	
	
	}

	
	
	
	
	
	@RequestMapping("/failBorrowBook")
	public String showfailBorrowBookPage() {

		return "failBorrowBook";
	}

	
	@RequestMapping("/failUsePoint")
	public String showfailUsePointPage() {

		return "failUsePoint";
	}

	
	
}

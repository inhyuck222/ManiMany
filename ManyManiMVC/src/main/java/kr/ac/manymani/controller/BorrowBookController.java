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

@Controller // 자바클래스를 bean으로 등록시킨다.
public class BorrowBookController {

	private BorrowService borrowService;
	private PointRuleService pointRuleService;
	//private PointRuleService pointRuleService;

	@Autowired // di 주입
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

		
		
		//borrowBook페이지에서 입력한 책번호를 받아온다.
		String bookNumber = request.getParameter("bookNumber");
		
		//memberInfo로 session에서 memberDomain을 받아왔당.
		Member loginStudent = (Member)session.getAttribute("loginStudent");
		
		Book book = borrowService.checkBorrow(bookNumber);
		if(book==null){
			System.out.println("책을 빌릴 없는  controller"+book);
			return "failBorrowBook";
			
		}
		
		if(book.getBorrowAvailability().equals("대여가능") ) {
			//책을 빌릴 수 있는 상태입 
			System.out.println("책을 빌릴 수 있는 controller"+book);
			model.addAttribute("TryBookModel", book);
			session.setAttribute("TryBookSession", book);
			return "DoBorrowBook";

		} else {
			//책을 빌릴수 없는 상태임 
			
			System.out.println("책을 빌릴 없는  controller"+book);
			return "failBorrowBook";
		}

		
	}
	
	
	@RequestMapping("/DoUsePoint")
	public String showDoUsePointPage(HttpServletRequest request,Model model,HttpSession session) {
		
		String usePoint = request.getParameter("point");
		Book book =(Book)session.getAttribute("TryBookSession");
		Member member =(Member)session.getAttribute("loginStudent");		
		
		System.out.println("책을 빌릴 수 있는 DoUsePoint"+book+usePoint+member);
		
		String rcv =borrowService.usePoint(usePoint,member,book);
		if(rcv.equals("대여싱패")){
			
			return "failUsePoint";
			
		}else{
	
			
		return "successBorrow";
	
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

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
import kr.ac.manymani.service.ReturnService;


@Controller // 자바클래스를 bean으로 등록시킨다.
public class ReturnBookController {

/*	private LoginService loginservice;*/
	private ReturnService returnService;
	
	@Autowired // di 주입
	public void setLoginService(ReturnService returnService) {
		this.returnService = returnService;
	}
	/*
	@Autowired//di 주입 
	public void setLoginService(LoginService loginservice){
	//	this.loginservice = loginservice;	
	}*/

	@RequestMapping("/returnBook")
	public String showReturnPage(){
	
		return "returnBook";
	}
	
	@RequestMapping("/DoReturnBook")
	public String DoReturnBookPage(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) {

		String bookNumber = request.getParameter("booknumber");
		Member member = (Member)session.getAttribute("memberInfo");
		Book book = returnService.returnBook(bookNumber);
		
		return null;
	}	
}
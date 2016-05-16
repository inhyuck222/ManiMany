package kr.ac.manymani.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.domain.Book;
import kr.ac.manymani.service.BorrowService;
import kr.ac.manymani.service.ReturnService;


@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class ReturnBookController {

/*	private LoginService loginservice;*/
	private ReturnService returnService;
	
	@Autowired // di ����
	public void setLoginService(ReturnService returnService) {
		this.returnService = returnService;
	}
	/*
	@Autowired//di ���� 
	public void setLoginService(LoginService loginservice){
	//	this.loginservice = loginservice;	
	}*/

	@RequestMapping("/returnBook")
	public String showReturnPage(){
	
		return "returnBook";
	}
	
	@RequestMapping("/DoReturnBook")
	public String DoReturnBookPage(HttpServletRequest request, HttpServletResponse response, Model model) {

		String bookNumber = request.getParameter("booknumber");
		System.out.println(bookNumber);
		Book book = returnService.returnBook(bookNumber);
		
		return null;
	}	
}
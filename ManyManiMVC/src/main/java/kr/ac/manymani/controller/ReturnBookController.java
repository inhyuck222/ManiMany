package kr.ac.manymani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller // 자바클래스를 bean으로 등록시킨다.
public class ReturnBookController {

/*	private LoginService loginservice;*/
	
	@Autowired//di 주입 
	public void setLoginService(/*LoginService loginservice*/){
	//	this.loginservice = loginservice;	
	}
	

	@RequestMapping("/returnBook")
	public String showReturnPage(){
	
		return "returnBook";
	}

		
	
}

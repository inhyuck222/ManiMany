package kr.ac.manymani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class ReturnBookController {

/*	private LoginService loginservice;*/
	
	@Autowired//di ���� 
	public void setLoginService(/*LoginService loginservice*/){
	//	this.loginservice = loginservice;	
	}
	

	@RequestMapping("/returnBook")
	public String showReturnPage(){
	
		return "returnBook";
	}

		
	
}

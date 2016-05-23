package kr.ac.manymani.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.domain.Member;
import kr.ac.manymani.service.LoginService;

@Controller // �ڹ�Ŭ������ bean���� ��Ͻ�Ų��.
public class LoginController {

	private LoginService loginservice;
	
	@Autowired//di ���� 
	public void setLoginService(LoginService loginservice){
		this.loginservice = loginservice;	
	}
	
	
	@RequestMapping("/login")
	public String showLoginPage(Model model){
	
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String loginProcess(Model model, HttpSession session, HttpServletRequest request){
		
		String tid = request.getParameter("id");
		String tpassword = request.getParameter("password");
		
		Member member=loginservice.checkMember(tid,tpassword);
		
		if(member == null){
			
			return "failLogin";
	
		} else {
			
			session.setAttribute("loginStudent", member);		
			session.setAttribute("logOk", member.getMemberId());
	
			return "home";
		}		
	}	

	
	@RequestMapping("/logout")
	public String showLogoutPage(){
		//�α׾ƿ��� Ȩ�������� �̵���Ų��.
		return "logout";
	}

	
	@RequestMapping("/guideLogin")
	public String showGuideLoginPage(){
		//�α׾ƿ��� Ȩ�������� �̵���Ų��.
		return "guideLogin";
	}
	
	
	
	@RequestMapping("/failLogin")
	public void showFailLoginPage(){
		//�α��� ���� ������ �̵���Ų��.
		System.out.println("�α��ν��� �޼���  �۵�");
		
	}
	
	

	
	
}

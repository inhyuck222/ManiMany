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

@Controller // 자바클래스를 bean으로 등록시킨다.
public class LoginController {

	private LoginService loginservice;
	
	@Autowired//di 주입 
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
		//로그아웃시 홈페이지로 이동시킨다.
		return "logout";
	}

	
	@RequestMapping("/guideLogin")
	public String showGuideLoginPage(){
		//로그아웃시 홈페이지로 이동시킨다.
		return "guideLogin";
	}
	
	
	
	@RequestMapping("/failLogin")
	public void showFailLoginPage(){
		//로그인 실패 페이지 이동시킨다.
		System.out.println("로그인실패 메서드  작동");
		
	}
	
	

	
	
}

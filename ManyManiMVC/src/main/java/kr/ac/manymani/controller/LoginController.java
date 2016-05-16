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
	
	
	/*	
	List<Member> members = loginservice.checkMember();
	model.addAttribute("members", members);
	*/
	
	@RequestMapping("/doLogin")
	public String loginProcess(Model model, HttpSession session, HttpServletRequest request){
		
		String tid = request.getParameter("id");
		String tpassword = request.getParameter("password");
		
		Member member=loginservice.checkMember2(tid,tpassword);
		
		if(member == null){
			return "home";
		} else {
			model.addAttribute("loginSucessObject", member);
			session.setAttribute("memberInfo", member);
			return "returnBook";
		}		
	}	

	@RequestMapping("/members")
	public String showMembers(Model model){

		List<Member> members = loginservice.checkMember();
		model.addAttribute("members", members);
		
		return "members";
	}
	
	@RequestMapping("/logout")
	public String showLogoutPage(Model model){
		//�α׾ƿ��� Ȩ�������� �̵���Ų��.
		return "home";
	}

	
}

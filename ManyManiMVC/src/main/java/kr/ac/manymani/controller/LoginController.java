package kr.ac.manymani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.manymani.dao.Member;
import kr.ac.manymani.service.LoginService;

@Controller // 자바클래스를 bean으로 등록시킨다.
public class LoginController {

	private LoginService loginservice;
	
	@Autowired//di 주입 
	public void setLoginService(LoginService loginservice){
		this.loginservice = loginservice;	
	}
	
	@RequestMapping("/members")
	public String showMembers(Model model){
		
		List<Member> members = loginservice.checkMember();
		model.addAttribute("members", members);
			
		return "members";
	}
	
	
	@RequestMapping("/createMember2")
	public String createMember(Model model){
		
	
		return "createMember2";
	}
	
	
	
}

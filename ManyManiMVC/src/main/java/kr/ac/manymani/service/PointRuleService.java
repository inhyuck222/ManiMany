package kr.ac.manymani.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.manymani.dao.BookDAO;
import kr.ac.manymani.domain.Member;

public class PointRuleService implements RuleService{
	@Override
	public int caclulateBorrowPoint(int point) {
		// TODO Auto-generated method stub
		
		/*
		controller에서 session으로 받아온 멤버를 매개변수르 넘겨줘야함
		Member bookDAO=bookDAO.getMember(tid);
		*/
		return 0;
		
	}

	@Override
	public int caclulateReturnPoint(Object member) {
		// TODO Auto-generated method stub
	
		
		
		return 0;
	}
	

}

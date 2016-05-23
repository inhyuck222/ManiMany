package kr.ac.manymani.service;

import kr.ac.manymani.domain.Member;

public interface RuleService {
	String caclulateBorrowPoint(Member member, String point,int currentPoint);
	int caclulateReturnPoint(Object book, Object member, int resultDate);
}

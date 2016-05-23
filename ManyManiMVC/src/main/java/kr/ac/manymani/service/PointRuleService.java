package kr.ac.manymani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.manymani.dao.BookDAO;
import kr.ac.manymani.domain.Book;
import kr.ac.manymani.domain.Member;

@Service("pointRuleService")
public class PointRuleService implements RuleService{
	@Override
	public String caclulateBorrowPoint(Member member, String usepoint, int currentPoint) {
		
		int resultLendingTerm=10;
		int intUsePoint = Integer.parseInt(usepoint);
		
		if(intUsePoint >= 100 && intUsePoint <= currentPoint ){
			resultLendingTerm += intUsePoint/100;
			member.setPoint(currentPoint-intUsePoint);	
			return resultLendingTerm+"";
		}else{
			
			System.out.println("포인트 오류입니다.");
			return "-1";
		}
	}

	@Override
	public int caclulateReturnPoint(Object objectBook, Object objectMember, int resultDate) {
		
		Book book= (Book)objectBook;
		Member member = (Member)objectMember;
		
		int point = member.getPoint();
		if(resultDate > 0) {
			point += 100;
		}
		else {
			point += resultDate*50;
		}		
		
		member.setPoint(point);
		
		return 0;
	}
	

}

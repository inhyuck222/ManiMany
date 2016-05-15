package kr.ac.manymani.dao;

public class Member {

	private int index;
	private String memberId;
	private String password;
	private String bookName;
	private String lendingTerm;
	private int point;
	private String email;

	public Member(){
			
		
	}

	public Member(int index, String memberId, String password, String bookName, String lendingTerm, int point,
			String email) {
		super();
		this.index = index;
		this.memberId = memberId;
		this.password = password;
		this.bookName = bookName;
		this.lendingTerm = lendingTerm;
		this.point = point;
		this.email = email;
	}

	public Member(String memberId, String password, String bookName, String lendingTerm, int point, String email) {
		super();

		this.memberId = memberId;
		this.password = password;
		this.bookName = bookName;
		this.lendingTerm = lendingTerm;
		this.point = point;
		this.email = email;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getLendingTerm() {
		return lendingTerm;
	}

	public void setLendingTerm(String lendingTerm) {
		this.lendingTerm = lendingTerm;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [index=" + index + ", memberId=" + memberId + ", password=" + password + ", bookName=" + bookName
				+ ", lendingTerm=" + lendingTerm + ", point=" + point + ", email=" + email + "]";
	}

}

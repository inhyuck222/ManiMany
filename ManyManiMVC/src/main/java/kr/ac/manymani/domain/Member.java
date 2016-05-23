package kr.ac.manymani.domain;

public class Member {


	private int index;
	private String memberId;
	private String password;
	private String bookName;
	private int point;
	private String email;
	private String borrowDate;
	private String returnDate;

	public Member(){
			
		
	}
	

	public Member(int index, String memberId, String password, String bookName, int point, String email,
			String borrowDate, String returnDate) {
	
		this.index = index;
		this.memberId = memberId;
		this.password = password;
		this.bookName = bookName;
		this.point = point;
		this.email = email;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	

	public Member(String memberId, String password, String bookName, int point, String email,
			String borrowDate, String returnDate) {
	
	
		this.memberId = memberId;
		this.password = password;
		this.bookName = bookName;
		this.point = point;
		this.email = email;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
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

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	
	@Override
	public String toString() {
		return "Member [index=" + index + ", memberId=" + memberId + ", password=" + password + ", bookName=" + bookName
				+ ", point=" + point + ", email=" + email + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate
				+ "]";
	}

}

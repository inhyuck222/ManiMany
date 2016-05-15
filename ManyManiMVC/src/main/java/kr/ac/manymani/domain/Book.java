package kr.ac.manymani.domain;

public class Book {
	
	
	private int index;
	private String bookNumber;
	private String bookName;
	private String borrowAvailability;
	private String lendingTerm;
	private String borrowerId;
	
	
	public Book(){
			
		
	}
	
	public Book(int index, String bookNumber, String bookName, String borrowAvailability, String lendingTerm, String borrowerId) {
		this.index=index;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.borrowAvailability = borrowAvailability;
		this.lendingTerm = lendingTerm;
		this.borrowerId = borrowerId;
	}



	public Book(String bookNumber, String bookName, String borrowAvailability, String lendingTerm, String borrowerId) {
		
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.borrowAvailability = borrowAvailability;
		this.lendingTerm = lendingTerm;
		this.borrowerId = borrowerId;
	}


	
	


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}



	public String getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBorrowAvailability() {
		return borrowAvailability;
	}


	public void setBorrowAvailability(String borrowAvailability) {
		this.borrowAvailability = borrowAvailability;
	}


	public String getLendingTerm() {
		return lendingTerm;
	}


	public void setLendingTerm(String lendingTerm) {
		this.lendingTerm = lendingTerm;
	}


	public String getBorrowerId() {
		return borrowerId;
	}


	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}


	@Override
	public String toString() {
		return "Book [index=" + index + ", bookNumber=" + bookNumber + ", bookName=" + bookName
				+ ", borrowAvailability=" + borrowAvailability + ", lendingTerm=" + lendingTerm + ", borrowerId="
				+ borrowerId + "]";
	}

	
	
}

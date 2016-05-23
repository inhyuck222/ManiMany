package kr.ac.manymani.domain;

public class Book {
	


	private int index;
	private String bookNumber;
	private String bookName;
	private String borrowAvailability;
	private String borrowerId;
	private String borrowDate;
	private String returnDate;
	
	
	
	public Book(){
			
		
	}
	
	
	public Book(String bookNumber, String bookName, String borrowAvailability, String borrowerId,
			String borrowDate, String returnDate) {
	

		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.borrowAvailability = borrowAvailability;
		this.borrowerId = borrowerId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
	public Book(int index, String bookNumber, String bookName, String borrowAvailability, String borrowerId,
			String borrowDate, String returnDate) {
		
		this.index = index;
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.borrowAvailability = borrowAvailability;
		this.borrowerId = borrowerId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
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



	public String getBorrowerId() {
		return borrowerId;
	}



	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
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
		return "Book [index=" + index + ", bookNumber=" + bookNumber + ", bookName=" + bookName
				+ ", borrowAvailability=" + borrowAvailability + ", borrowerId=" + borrowerId + ", borrowDate="
				+ borrowDate + ", returnDate=" + returnDate + "]";
	}

}

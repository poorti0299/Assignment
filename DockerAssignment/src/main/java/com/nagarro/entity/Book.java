package com.nagarro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@Column(name = "bookid")
	private int bookId;

	@Column(name = "bookname")
	private String bookName;

	@Column(name = "authorname")
	private String authorName;


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", currentDate="
				+ currentDate + "]";
	}

	@Column(name = "modifieddate")
	private String currentDate;

	public int getBookCode() {
		return bookId;
	}

	public void setBookCode(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDate() {
		return currentDate;
	}

	public void setDate(String currentDate) { 
		this.currentDate=currentDate;
	}
}
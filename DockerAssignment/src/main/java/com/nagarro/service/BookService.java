package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.dto.BookDto;
import com.nagarro.entity.Book;

/*
 * Book service Interface
 */

@Service
public interface BookService {
	
	public List<BookDto> getAllData();
	public void delete(int id) throws Exception;
	public void update(Book book,int id) throws Exception;
	public void insertBook(Book book);
	public Book validateID(int id);
}
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dto.BookDto;
import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;


@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getBooks() { 
		List<BookDto> allData = bookService.getAllData();
		
		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData,HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/books/{id}")
	public ResponseEntity validateID(@PathVariable("id") int id) { 
		Book res = bookService.validateID(id);
		if(res != null) {
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	@PostMapping(path="/books")
	public void postHome(@RequestBody Book book) {
		//System.out.println("Author name "+book.getAuthorName());
		bookService.insertBook(book);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/books/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		try {
			bookService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("No book Found with given id", HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Object> update(@RequestBody BookDto bookData,@PathVariable("id") int id) {
		try {
			Book book = new Book();
			book.setBookCode(bookData.getBookCode());
			book.setBookName(bookData.getBookName());
			book.setDate(bookData.getDate());
			book.setAuthorName(bookData.getAuthorName());
			bookService.update(book,id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 return new ResponseEntity<>("No book Found with given id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/author")
	public List<Author> getAuthor() {
		return authorService.getAuthor();
	}
}
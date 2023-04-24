package com.nagarro.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.dao.AuthorRepository;
import com.nagarro.entity.Author;
import com.nagarro.service.AuthorService;


@Component
public class AuthorServiceImp implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> getAuthor() {
		return (List<Author>) authorRepository.findAll();
	}

}
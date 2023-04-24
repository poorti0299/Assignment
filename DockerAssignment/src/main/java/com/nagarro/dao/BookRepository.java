package com.nagarro.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.entity.Book;

/*
 * Repository class to perform CRUD operations on Book class
 */

public interface BookRepository extends CrudRepository<Book, Integer>{

}
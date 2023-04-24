package com.nagarro.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Author;


/*
 * Repository class to perform CRUD operations on Author class
 */

@Repository
public interface AuthorRepository extends CrudRepository<Author, String>{

}
package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;

import java.util.List;

public interface BookService {
	// Get all
    List<Books> fetchBookList();
    
	// Create
    Books saveBook(Books book);
 
    // Update
    Books updateBook(Books book, Long id);
 
    // Delete
    void deleteBookById(Long id);
    
    //Search by title

}

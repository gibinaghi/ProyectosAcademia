package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping("/api")
public class BooksController {
	@Autowired
	private BookService booksService;
	
	// Get all 
    @GetMapping("/books")
    public List<Books> fetchBookList()
    {
        return booksService.fetchBookList();
    }
    
    // Create
    @PostMapping("/book")
    public Books saveBook(@RequestBody Books book)
    {
        return booksService.saveBook(book);
    }
    
    // Update
    @PatchMapping("/book/{id}")
    public Books updateBook(
    		@RequestBody Books book,
            @PathVariable("id") Long id)
    {
        return booksService.updateBook(book, id);
    }
 
    // Delete
    @DeleteMapping("/book/{id}")
    public String deleteBookById(@PathVariable("id") Long id)
    {
    	try {
    	booksService.deleteBookById(id);
        return "Deleted Successfully";
    	}catch(Exception e){
    		return "ERROR: No deleted";
    	}
    }

    // Search by title

}

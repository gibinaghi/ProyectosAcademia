package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import java.util.List;
import java.util.Objects;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
    private BooksRepository booksRepository;
 
	// Get all
    @Override 
    public List<Books> fetchBookList()
    {
        return (List<Books>) booksRepository.findAll();
    }
    
    // Create
    @Override
    public Books saveBook(Books book)
    {
        return booksRepository.save(book);
    }
 
    // Update
    @Override
    public Books updateBook(Books book, Long id)
    {
        Books bookDB = booksRepository.findById(id).get();
 
        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
        	bookDB.setAuthor(book.getAuthor());
        }
        
        if (Objects.nonNull(book.getAvailable())) {
        	bookDB.setAvailable(book.getAvailable());
        }
        
        if (Objects.nonNull(book.getCategory()) && !"".equalsIgnoreCase(book.getCategory())) {
        	bookDB.setCategory(book.getCategory());
        }
        
        if (Objects.nonNull(book.getDate()) && !"".equalsIgnoreCase(book.getDate())) {
        	bookDB.setDate(book.getDate());
        }
        
        if (Objects.nonNull(book.getDescription()) && !"".equalsIgnoreCase(book.getDescription())) {
        	bookDB.setDescription(book.getDescription());
        }
        
        if (Objects.nonNull(book.getEdit()) && !"".equalsIgnoreCase(book.getEdit())) {
        	bookDB.setEdit(book.getEdit());
        }
        
        if (Objects.nonNull(book.getLang()) && !"".equalsIgnoreCase(book.getLang())) {
        	bookDB.setLang(book.getLang());
        }
        
        if (Objects.nonNull(book.getStock())) {
        	bookDB.setStock(book.getStock());
        }
        
        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
        	bookDB.setTitle(book.getTitle());
        }
 
        return booksRepository.save(bookDB);
    }
 
    // Delete
    @Override
    public void deleteBookById(Long id)
    {
    	booksRepository.deleteById(id);	
    }
}

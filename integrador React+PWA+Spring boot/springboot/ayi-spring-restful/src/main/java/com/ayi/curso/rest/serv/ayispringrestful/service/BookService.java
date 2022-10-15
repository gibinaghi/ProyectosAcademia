package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

import java.util.List;

public interface BookService {
    // Get all
    List<BookDTOResponse> fetchBookList()
            throws NotFoundException, InternalException;

    // Create
    BookDTOResponse createBook(BookCreateDTORequest bookRequest);
 
    // Update --> faltan las excepciones
    //Books updateBook(Books book, Long id);

    // Delete
    void deleteBook(Long idBook)
            throws BadRequestException, InternalException, NotFoundException;
    
    //Search by title --> faltan las excepciones
    List<Books> searchByTitle(String title);

}

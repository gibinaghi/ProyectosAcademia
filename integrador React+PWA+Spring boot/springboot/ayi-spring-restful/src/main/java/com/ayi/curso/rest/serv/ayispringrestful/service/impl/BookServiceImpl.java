package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IBooksMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.BookService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NULL;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
    private BooksRepository booksRepository;

    private IBooksMapper booksMapper;

    // Get all
    @Override
    @Transactional
    public List<BookDTOResponse> fetchBookList()
            throws NotFoundException, InternalException
    {
        List<Books> entityList = null;
        try {
            entityList = booksRepository.findAll();
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(entityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<BookDTOResponse> listResponse = new ArrayList<>();
        entityList.forEach(book -> {
            BookDTOResponse bookResponse = booksMapper.convertEntityToDto(book);
            listResponse.add(bookResponse);
        });

        return listResponse ;
    }
    
    // Create
    @Override
    @Transactional
    public BookDTOResponse createBook(BookCreateDTORequest bookRequest)
    {
        Books bookEntity = booksMapper.convertDtoToEntityCreate(bookRequest);

        //Save
        bookEntity = booksRepository.save(bookEntity);

        return booksMapper.convertEntityToDto(bookEntity);
    }
 
    // Update --> faltan las excepciones
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
    public void deleteBook(Long idBook)
            throws BadRequestException, InternalException, NotFoundException {

        if(idBook == null || idBook < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Books> entity = null;
        try {
            entity = booksRepository.findById(idBook);
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if (entity.isPresent()) {
            booksRepository.deleteById(idBook);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }

    // Search by title --> faltan las excepciones
    @Override
    public List<Books> searchByTitle(String title)
    {
        return (List<Books>) booksRepository.findByTitle(title);
    }
}

package com.ayi.curso.rest.serv.ayispringrestful.constants.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ayi.curso.rest.serv.ayispringrestful.constants.service.BookService;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IBooksMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NULL;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    // Repository
    private BooksRepository booksRepository;

    // Mapper
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
 
    // Update
    @Override
    @Transactional
    public BookDTOResponse updateBook(BookUpdateDTORequest bookUpdateDTORequest, Long id)
            throws BadRequestException
    {
        if(id == null || id < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Books book = booksMapper.convertDtoToEntityUpdate(bookUpdateDTORequest);

        Books bkDB = booksRepository.findById(id).get();

        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
            bkDB.setTitle(book.getTitle());
        }

        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
            bkDB.setAuthor(book.getAuthor());
        }

        if (Objects.nonNull(book.getCategory()) && !"".equalsIgnoreCase(book.getCategory())) {
            bkDB.setCategory(book.getCategory());
        }

        if (Objects.nonNull(book.getEdition()) && !"".equalsIgnoreCase(book.getEdition())) {
            bkDB.setEdition(book.getEdition());
        }

        if (Objects.nonNull(book.getIdiom()) && !"".equalsIgnoreCase(book.getIdiom())) {
            bkDB.setIdiom(book.getIdiom());
        }

        if (Objects.nonNull(book.getStock()) && book.getStock() > 0) {
            bkDB.setStock(book.getStock());
        }


        bkDB = booksRepository.save(bkDB);

        return booksMapper.convertEntityToDto(bkDB);
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

    // Search by title
    @Override
    public List<BookDTOResponse> searchByTitle(String title)
    {
        List<Books> listBooks = booksRepository.findByTitle(title);

        List<BookDTOResponse> listResponse = new ArrayList<>();
        listBooks.forEach(book -> {
            BookDTOResponse bookResponse = booksMapper.convertEntityToDto(book);
            listResponse.add(bookResponse);
        });

        return listResponse ;
    }
}

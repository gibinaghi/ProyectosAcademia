package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IBooksMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.BookService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NULL;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    // Repository
    @NotNull
    private BooksRepository booksRepository;

    // Mapper
    @NotNull
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
            throws BadRequestException
    {
        Books bookEntity = booksMapper.convertDtoToEntityCreate(bookRequest);

        if(
                bookEntity.getTitle().isEmpty() || bookEntity.getAuthor().isEmpty() ||
                        bookEntity.getCategory().isEmpty() || bookEntity.getEdition().isEmpty() ||
                        bookEntity.getIdiom().isEmpty() || bookEntity.getStock() == null
        ){
            throw new BadRequestException(EXCEPTION_FIEL_REQ);
        }

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
        throws NotFoundException
    {
        List<Books> listBooks = booksRepository.findByTitle(title);

        if(listBooks.isEmpty()){
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<BookDTOResponse> listResponse = new ArrayList<>();
        listBooks.forEach(book -> {
            BookDTOResponse bookResponse = booksMapper.convertEntityToDto(book);
            listResponse.add(bookResponse);
        });

        return listResponse ;
    }
}

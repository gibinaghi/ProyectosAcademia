package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.BookService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Book Api", tags = {"Book Service"})
@RequestMapping(value = "/api")
@AllArgsConstructor
@RestController
public class BooksController {
	private BookService booksService;

    // Get all
    @GetMapping(
            value = "/books",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(
            value = "List all books",
            httpMethod = "GET",
            response = BookDTOResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of books",
                    response = BookDTOResponse[].class
            ),
            @ApiResponse(code = 404, message = "Books not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public ResponseEntity<?> fetchBookList() throws NotFoundException, InternalException
    {
        ResponseEntity<?> response;
        try {
            List<BookDTOResponse> bookResponse = booksService.fetchBookList();
            return ResponseEntity.ok(bookResponse );
        }catch (InternalException e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (NotFoundException e){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return response;
    }
    
    // Create
    @PostMapping(
            value = "/book",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create book",
            httpMethod = "POST",
            response = BookDTOResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about book",
                    response = BookDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> createBook(
            @ApiParam(value = "data of book", required = true)
            @RequestBody BookCreateDTORequest request
    ) throws BadRequestException {
        ResponseEntity<?> response;
        try {
            BookDTOResponse bookResponse = booksService.createBook(request);
            return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return response;
    }

    // Update
    @PatchMapping(
            value = "/book/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Update book",
            httpMethod = "PATCH",
            response = BookDTOResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about book",
                    response = BookDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> updateBook(
            @RequestBody BookUpdateDTORequest book,
            @PathVariable("id") Long id
    ) throws BadRequestException {
        ResponseEntity<?> response;
        try {
            BookDTOResponse bookResponse = booksService.updateBook(book, id);
            return ResponseEntity.ok(bookResponse);
        } catch (BadRequestException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return response;
    }

    // Delete
    @DeleteMapping("/book/{id}")
    @ApiOperation(
            value = "Delete a book by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Book deleted by id"),
            @ApiResponse(code = 404, message = "Book not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public ResponseEntity<?> deleteBook(
            @ApiParam(name = "id", required = true, value = "Book Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        ResponseEntity<?> response;
        try {
            booksService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (BadRequestException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (InternalException e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (NotFoundException e){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return response;
    }

    // Search by title
    @GetMapping("/books/{title}")
    @ApiOperation(
            value = "Search book by title",
            httpMethod = "GET",
            response = BookDTOResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about book",
                    response = BookDTOResponse[].class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> searchByName(@PathVariable("title") String title)
            throws NotFoundException

    {
        ResponseEntity<?> response;
        try {
            List<BookDTOResponse> bookResponse = booksService.searchByTitle(title);
            return ResponseEntity.ok(bookResponse);
        } catch (NotFoundException e){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return response;
    }

}

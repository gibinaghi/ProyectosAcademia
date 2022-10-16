package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.BookUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.constants.service.BookService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Book Api", tags = {"Book Service"})
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class BooksController {
	private BookService booksService;

    // Get all
    @GetMapping("/books")
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
    })
    public ResponseEntity<?> fetchBookList() throws NotFoundException, InternalException
    {
        List<BookDTOResponse> bookResponse = booksService.fetchBookList();
        return ResponseEntity.ok(bookResponse );
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
    public ResponseEntity<BookDTOResponse> createBook(
            @ApiParam(value = "data of book", required = true)
            @RequestBody BookCreateDTORequest request
    ) {
        BookDTOResponse bookResponse = booksService.createBook(request);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    // Update
    @PatchMapping("/book/{id}")
    public ResponseEntity<BookDTOResponse> updateBook(
            @RequestBody BookUpdateDTORequest book,
            @PathVariable("id") Long id
    ) throws BadRequestException {
        BookDTOResponse bookResponse = booksService.updateBook(book, id);
        return ResponseEntity.ok(bookResponse);
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
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteBook(
            @ApiParam(name = "id", required = true, value = "Book Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        booksService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Search by title
    @GetMapping("/books/{title}")
    public List<BookDTOResponse> searchByName(@PathVariable("title") String title)

    {
        return booksService.searchByTitle(title);
    }

}

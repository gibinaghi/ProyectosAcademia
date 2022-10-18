package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.LendingService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "Lending Api", tags = {"Lending Service"})
@RequestMapping(value = "/api")
@AllArgsConstructor
@RestController
public class LendingsController {
	private LendingService lendingService;

    // Create
    @PostMapping(
            value = "/lending",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create lending",
            httpMethod = "POST",
            response = LendingDTOResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about lending",
                    response = LendingDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public ResponseEntity<LendingDTOResponse> createLending(
            @ApiParam(value = "data of lending", required = true)
            @RequestParam("userId") Long userId,
            @RequestParam("bookId") Long bookId,
            @RequestBody LendingCreateDTORequest request
    ) throws BadRequestException, NotFoundException {
        LendingDTOResponse lendResponse = lendingService.createLending(request, userId, bookId);
        return new ResponseEntity<>(lendResponse, HttpStatus.CREATED);
    }

}
